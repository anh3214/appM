package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.ui.activities.MedicineListActivity
import com.example.myapplication.ui.theme.MyApplicationTheme
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.ui.activities.AddMedicineActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val viewListButton: Button = findViewById(R.id.button_view_list)
        val addMedicineButton: Button = findViewById(R.id.button_add_medicine)

        viewListButton.setOnClickListener {
            startActivity(Intent(this, MedicineListActivity::class.java))
        }

        addMedicineButton.setOnClickListener {
            startActivity(Intent(this, AddMedicineActivity::class.java))
        }
    }
}