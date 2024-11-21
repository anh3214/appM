package com.example.myapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.entities.Medicine

@Dao
interface MedicineDao {
    @Insert
    suspend fun insertMedicine(medicine: Medicine)

    @Query("SELECT * FROM Medicine WHERE medicineId = :id")
    suspend fun getMedicineById(id: String): Medicine?

    @Query("SELECT * FROM Medicine")
    suspend fun getAllMedicines(): List<Medicine>
}