package com.example.members_api.model

data class membersItem(
    val created_at: String,
    val githubUrl: String,
    val id: Int,
    val imageUrl: ImageUrl,
    val linkedinUrl: String,
    val mailID: String,
    val name: String,
    val position: String,
    val published_at: String,
    val ringColor: Int,
    val updated_at: String
)