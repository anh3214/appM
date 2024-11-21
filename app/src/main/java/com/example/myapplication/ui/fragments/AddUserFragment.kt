package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.model.entities.User
import com.example.myapplication.model.repositories.UserRepository
import kotlinx.coroutines.launch

class AddUserFragment(private val repository: UserRepository) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_add_user, container, false)

        val userIdInput: EditText = view.findViewById(R.id.user_id_input)
        val nameInput: EditText = view.findViewById(R.id.name_input)
        val ageInput: EditText = view.findViewById(R.id.age_input)
        val genderInput: EditText = view.findViewById(R.id.gender_input)
        val roleInput: EditText = view.findViewById(R.id.role_input)
        val saveButton: Button = view.findViewById(R.id.save_user_button)

        saveButton.setOnClickListener {
            try {
                val userId = userIdInput.text.toString()
                val name = nameInput.text.toString()
                val age = ageInput.text.toString().toIntOrNull() ?: 0
                val gender = genderInput.text.toString().toIntOrNull() ?: 0
                val role = roleInput.text.toString().toIntOrNull() ?: 0

                // Validate required fields
                if (userId.isBlank() || name.isBlank()) {
                    Toast.makeText(requireContext(), "User ID and Name are required!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Create user object
                val user = User(userId, name, age, gender, role)

                lifecycleScope.launch {
                    try {
                        repository.insertUser(user)
                        Toast.makeText(requireContext(), "User saved successfully", Toast.LENGTH_SHORT).show()
                        requireActivity().finish()
                    } catch (e: Exception) {
                        // Handle repository exceptions
                        Toast.makeText(requireContext(), "Error saving user: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                // Catch unexpected exceptions
                Toast.makeText(requireContext(), "Unexpected error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
