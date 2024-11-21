package com.example.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.model.repositories.MedicineRepository
import android.util.Log
import com.example.myapplication.ui.fragments.AddMedicineFragment

class AddMedicineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_add)
            Log.d("AddMedicineActivity", "setContentView successfully called.")
        } catch (e: Exception) {
            Log.e("AddMedicineActivity", "Error during setContentView: ${e.message}", e)
        }

        try {
            val database = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()

            val repository = MedicineRepository(database.medicineDao())
            showFragment(AddMedicineFragment(repository))
        } catch (e: Exception) {
            Log.e("AddMedicineActivity", "Error initializing database or fragment: ${e.message}", e)
        }
    }

    private fun showFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_add, fragment)
                .commit()
            Log.d("AddMedicineActivity", "Fragment added successfully.")
        } catch (e: Exception) {
            Log.e("AddMedicineActivity", "Error showing fragment: ${e.message}", e)
        }
    }
}