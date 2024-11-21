package com.example.myapplication.model.repositories

import com.example.myapplication.data.database.SchedulingDao
import com.example.myapplication.model.entities.Scheduling

class SchedulingRepository(private val schedulingDao: SchedulingDao) {
    suspend fun insertScheduling(scheduling: Scheduling) = schedulingDao.insertScheduling(scheduling)
    suspend fun getSchedulingById(id: String) = schedulingDao.getSchedulingById(id)
}