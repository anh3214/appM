package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.myapplication.ui.activities.MedicineListActivity
import android.widget.Button
import com.example.myapplication.ui.activities.AddMedicineActivity
import com.example.myapplication.ui.activities.AddUserActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val viewListButton: Button = findViewById(R.id.button_view_list)
        val addMedicineButton: Button = findViewById(R.id.button_add_medicine)
        val addUserButton: Button = findViewById(R.id.button_add_user)

        viewListButton.setOnClickListener {
            startActivity(Intent(this, MedicineListActivity::class.java))
        }

        addMedicineButton.setOnClickListener {
            startActivity(Intent(this, AddMedicineActivity::class.java))
        }

        addUserButton.setOnClickListener {
            startActivity(Intent(this, AddUserActivity::class.java))
        }
    }
}