package com.example.myapplication.model.repositories

import com.example.myapplication.data.database.ReportDao
import com.example.myapplication.model.entities.Report

class ReportRepository(private val reportDao: ReportDao) {
    suspend fun insertReport(report: Report) = reportDao.insertReport(report)
    suspend fun getReportById(id: String) = reportDao.getReportById(id)
}