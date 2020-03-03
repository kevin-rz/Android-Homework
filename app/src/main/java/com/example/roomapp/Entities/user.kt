package com.example.roomapp.Entities

import androidx.room.*

@Entity

data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val email: String,
    val password: String
)