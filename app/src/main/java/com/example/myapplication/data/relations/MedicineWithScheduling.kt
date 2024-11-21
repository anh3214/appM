package com.example.myapplication.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.myapplication.model.entities.Medicine
import com.example.myapplication.model.entities.Scheduling

data class MedicineWithScheduling(
    @Embedded val medicine: Medicine,
    @Relation(
        parentColumn = "medicineId",
        entityColumn = "medicineId"
    )
    val schedulings: List<Scheduling>
)