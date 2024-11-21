package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.repositories.MedicineRepository
import com.example.myapplication.ui.adapters.MedicineAdapter
import kotlinx.coroutines.launch

class MedicineListFragment(private val repository: MedicineRepository) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_medicine_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.medicine_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            try {
                val medicines = repository.getAllMedicines()
                recyclerView.adapter = MedicineAdapter(medicines)
            } catch (e: Exception) {
                // Handle any errors during the database operation
                Toast.makeText(requireContext(), "Failed to load medicines: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}