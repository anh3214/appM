package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapplication.model.entities.User
import com.example.myapplication.data.relations.UserWithMedicines

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM User WHERE userId = :id")
    suspend fun getUserById(id: String): User?

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    suspend fun getUserWithMedicines(userId: String): UserWithMedicines
}