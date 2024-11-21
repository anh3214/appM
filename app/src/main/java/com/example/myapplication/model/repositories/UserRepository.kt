package com.example.myapplication.model.repositories

import com.example.myapplication.data.database.UserDao
import com.example.myapplication.model.entities.User

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    suspend fun getUserById(id: String) = userDao.getUserById(id)
    suspend fun getAllUsers() = userDao.getAllUsers()
}