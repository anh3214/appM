package com.example.myapplication.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey val userId: String,
    val name: String,
    val age: Int,
    val gender: Int,
    val role: Int
)