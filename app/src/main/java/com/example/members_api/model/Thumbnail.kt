package com.example.members_api.model

data class Thumbnail(
    val ext: String,
    val hash: String,
    val height: Int,
    val mime: String,
    val name: String,
    val path: Any,
    val size: Double,
    val url: String,
    val width: Int
)