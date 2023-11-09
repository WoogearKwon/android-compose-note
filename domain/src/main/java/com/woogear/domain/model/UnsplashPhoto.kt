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
    val raw: String? = null,
    val full: String? = null,
    val regular: String? = null,
    val thumb: String? = null,
    val smallS3: String? = null,
)