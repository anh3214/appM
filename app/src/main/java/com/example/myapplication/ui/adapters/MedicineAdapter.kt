package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.entities.Medicine

class MedicineAdapter(private val medicines: List<Medicine>) :
    RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    class MedicineViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val medicineId: TextView = view.findViewById(R.id.medicine_id)
        val function: TextView = view.findViewById(R.id.medicine_function)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = medicines[position]
        holder.medicineId.text = medicine.medicineId
        holder.function.text = medicine.function
    }

    override fun getItemCount(): Int = medicines.size
}