package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.model.entities.Medicine
import com.example.myapplication.model.repositories.MedicineRepository
import kotlinx.coroutines.launch

class AddMedicineFragment(private val repository: MedicineRepository) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_add_medicine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val medicineIdInput: EditText = view.findViewById(R.id.medicine_id_input)
        val userIdInput: EditText = view.findViewById(R.id.user_id_input)
        val functionInput: EditText = view.findViewById(R.id.function_input)
        val usageInput: EditText = view.findViewById(R.id.usage_input)
        val noteInput: EditText = view.findViewById(R.id.note_input)
        val storageConditionInput: EditText = view.findViewById(R.id.storage_condition_input)
        val ingredientsInput: EditText = view.findViewById(R.id.ingredients_input)
        val mealScheduleInput: EditText = view.findViewById(R.id.meal_schedule_input)
        val quantityLeftInput: EditText = view.findViewById(R.id.quantity_left_input)
        val warehouseNoInput: EditText = view.findViewById(R.id.warehouse_no_input)
        val timesPerDayInput: EditText = view.findViewById(R.id.times_per_day_input)

        val addButton: Button = view.findViewById(R.id.button_add_medicine)

        addButton.setOnClickListener {
            val medicine = Medicine(
                medicineId = medicineIdInput.text.toString(),
                userId = userIdInput.text.toString(),
                function = functionInput.text.toString(),
                usage = usageInput.text.toString(),
                note = noteInput.text.toString(),
                storageCondition = storageConditionInput.text.toString(),
                ingredients = ingredientsInput.text.toString(),
                mealSchedule = mealScheduleInput.text.toString().toIntOrNull() ?: 0,
                quantityLeft = quantityLeftInput.text.toString().toIntOrNull() ?: 0,
                warehouseNo = warehouseNoInput.text.toString().toIntOrNull() ?: 0,
                timesPerDay = timesPerDayInput.text.toString().toIntOrNull() ?: 0
            )

            lifecycleScope.launch {
                repository.insertMedicine(medicine)
            }
        }
    }
}