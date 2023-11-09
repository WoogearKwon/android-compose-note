package com.woogear.data.network.dto.response

import com.woogear.domain.model.UnsplashUser
import com.woogear.domain.model.UnsplashUserProfileImage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkUnsplashUser(

    @SerialName("id")
    val id: String,

    @SerialName("username")
    val userName: String? = null,

    @SerialName("location")
    val location: String? = null,

    @SerialName("profile_image")
    val profileImage: NetworkUnsplashUserProfileImage,
)

@Serializable
data class NetworkUnsplashUserProfileImage(

    @SerialName("small")
    val small: String? = null,

    @SerialName("medium")
    val medium: String? = null,

    @SerialName("large")
    val large: String? = null,
)

fun NetworkUnsplashUser.asDomainModel(): UnsplashUser {
    return UnsplashUser(
        id = id,
        userName = userName,
        location = location,
        profileImage = profileImage.asDomainModel(),
    )
}

fun NetworkUnsplashUserProfileImage.asDomainModel(): UnsplashUserProfileImage {
    return UnsplashUserProfileImage(
        small = small,
        medium = medium,
        large = large,
    )
}