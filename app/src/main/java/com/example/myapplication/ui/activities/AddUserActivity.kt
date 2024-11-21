package com.example.myapplication.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.model.repositories.UserRepository
import com.example.myapplication.ui.fragments.AddUserFragment

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_add)
            Log.d("AddUserActivity", "setContentView successfully called.")
        } catch (e: Exception) {
            Log.e("AddUserActivity", "Error during setContentView: ${e.message}", e)
            Toast.makeText(this, "Error initializing UI. Please restart the app.", Toast.LENGTH_SHORT).show()
        }

        try {
            val database = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()

            val repository = UserRepository(database.userDao())
            showFragment(AddUserFragment(repository))
        } catch (e: Exception) {
            Log.e("AddUserActivity", "Error initializing database or fragment: ${e.message}", e)
            Toast.makeText(this, "Error loading data. Please try again later.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_add, fragment)
                .commit()
            Log.d("AddUserActivity", "Fragment added successfully.")
        } catch (e: Exception) {
            Log.e("AddUserActivity", "Error showing fragment: ${e.message}", e)
            Toast.makeText(this, "Error loading the form. Please try again.", Toast.LENGTH_SHORT).show()
        }
    }
}
