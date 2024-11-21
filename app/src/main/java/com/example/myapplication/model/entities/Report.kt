package com.example.myapplication.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Report",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE // Khi xóa User, Report cũng bị xóa
        )
    ]
)
data class Report(
    @PrimaryKey val reportId: String,
    val userId: String,
    val period: String,
    val success: Int,
    val fail: Int
)