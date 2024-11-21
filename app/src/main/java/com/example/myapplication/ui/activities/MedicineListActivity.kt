package com.example.myapplication.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.model.repositories.MedicineRepository
import com.example.myapplication.ui.fragments.MedicineListFragment

class MedicineListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        try {
            // Initialize the database
            val database = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()
            val repository = MedicineRepository(database.medicineDao())
            showFragment(MedicineListFragment(repository))
        } catch (e: Exception) {
            Toast.makeText(this, "Error initializing the database: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_containerList, fragment)
            .commit()
    }
}
