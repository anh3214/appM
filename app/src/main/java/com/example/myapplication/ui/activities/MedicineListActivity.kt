package com.example.myapplication.ui.activities

import android.os.Bundle
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

        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()

        val repository = MedicineRepository(database.medicineDao())
        showFragment(MedicineListFragment(repository))
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_containerList, fragment)
            .commit()
    }
}