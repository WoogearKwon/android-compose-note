package com.woogear.domain.model

data class UnsplashUser(
    val id: String,
    val userName: String? = null,
    val location: String? = null,
    val profileImage: UnsplashUserProfileImage,
)

data class UnsplashUserProfileImage(
    val small: String? = null,
    val medium: String? = null,
    val large: String? = null,
)

