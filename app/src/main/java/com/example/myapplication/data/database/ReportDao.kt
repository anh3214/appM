package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapplication.data.relations.UserWithReports
import com.example.myapplication.model.entities.Report

@Dao
interface ReportDao {
    @Insert
    suspend fun insertReport(report: Report)

    @Query("SELECT * FROM Report WHERE reportId = :id")
    suspend fun getReportById(id: String): Report?

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    suspend fun getUserWithReports(userId: String): UserWithReports
}