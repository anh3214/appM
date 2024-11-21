package com.example.myapplication.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.myapplication.model.entities.Medicine
import com.example.myapplication.model.entities.User

data class UserWithMedicines(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val medicines: List<Medicine>
)