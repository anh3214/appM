package com.example.myapplication.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Medicine",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE // Khi xóa User, Medicine cũng bị xóa
        )
    ]
)
data class Medicine(
    @PrimaryKey val medicineId: String,
    val userId: String,
    val function: String,
    val usage: String,
    val note: String,
    val storageCondition: String,
    val ingredients: String,
    val mealSchedule: Int,
    val quantityLeft: Int,
    val warehouseNo: Int,
    val timesPerDay: Int
)