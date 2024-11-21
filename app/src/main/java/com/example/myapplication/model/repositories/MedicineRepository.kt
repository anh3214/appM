package com.example.myapplication.model.repositories

import com.example.myapplication.data.database.MedicineDao
import com.example.myapplication.model.entities.Medicine

class MedicineRepository(private val medicineDao: MedicineDao) {
    suspend fun insertMedicine(medicine: Medicine) = medicineDao.insertMedicine(medicine)
    suspend fun getMedicineById(id: String) = medicineDao.getMedicineById(id)
    suspend fun getAllMedicines() = medicineDao.getAllMedicines()
}