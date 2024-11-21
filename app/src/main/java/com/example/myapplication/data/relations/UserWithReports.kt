package com.example.myapplication.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.myapplication.model.entities.Report
import com.example.myapplication.model.entities.User

data class UserWithReports(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val reports: List<Report>
)