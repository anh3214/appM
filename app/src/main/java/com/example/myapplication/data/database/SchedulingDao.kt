package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.entities.Scheduling

@Dao
interface SchedulingDao {
    @Insert
    suspend fun insertScheduling(scheduling: Scheduling)

    @Query("SELECT * FROM Scheduling WHERE scheduleId = :id")
    suspend fun getSchedulingById(id: String): Scheduling?
}