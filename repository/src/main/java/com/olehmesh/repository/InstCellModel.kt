package com.olehmesh.repository

data class InstCellModel(
    val id: Int,
    val logo: String,
    val login: String,
    val location: String,
    val images: List<String>,
    val likes: List<String>,
    val hashTags: List<String>,
    val lastVisit: String
)