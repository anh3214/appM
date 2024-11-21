package com.example.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.model.entities.*

@Database(
    entities = [User::class, Medicine::class, Report::class, Scheduling::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun medicineDao(): MedicineDao
    abstract fun reportDao(): ReportDao
    abstract fun schedulingDao(): SchedulingDao
}