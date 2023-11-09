package com.woogear.domain.model

data class UnsplashPhoto(
    val id: String? = null,
    val createdAt: String? = null,
    val width: Int,
    val height: Int,
    val color: String? = null,
    val urls: UnsplashPhotoUrls,
    val likes: Int,
    val likedByUser: Boolean,
    val description: String? = null,
    val user: UnsplashUser,
)

data class UnsplashPhotoUrls(
    val raw: String,
    val full: String,
    val regular: String,
    val thumb: String,
    val smallS3: String,
)