package com.example.myapplication.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Scheduling",
    foreignKeys = [
        ForeignKey(
            entity = Medicine::class,
            parentColumns = ["medicineId"],
            childColumns = ["medicineId"],
            onDelete = ForeignKey.CASCADE // Khi xóa Medicine, Scheduling cũng bị xóa
        )
    ]
)
data class Scheduling(
    @PrimaryKey val scheduleId: String,
    val medicineId: String,
    val quantity: Int,
    val hour: Int,
    val min: Int
)