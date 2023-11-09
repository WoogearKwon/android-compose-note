package com.woogear.data.network.dto.response

import com.woogear.domain.model.UnsplashPhoto
import com.woogear.domain.model.UnsplashPhotoUrls
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkUnsplashPhoto(
    @SerialName("id")
    val id: String? = null,

    @SerialName("created_at")
    val createdAt: String? = null,

    @SerialName("width")
    val width: Int,

    @SerialName("height")
    val height: Int,

    @SerialName("color")
    val color: String? = null,

    @SerialName("urls")
    val urls: NetworkUnsplashPhotoUrls,

    @SerialName("likes")
    val likes: Int,

    @SerialName("liked_by_user")
    val likedByUser: Boolean,

    @SerialName("description")
    val description: String? = null,

    @SerialName("user")
    val user: NetworkUnsplashUser,
)

@Serializable
data class NetworkUnsplashPhotoUrls(
    @SerialName("raw")
    val raw: String,

    @SerialName("full")
    val full: String,

    @SerialName("regular")
    val regular: String,

    @SerialName("thumb")
    val thumb: String,

    @SerialName("small_s3")
    val smallS3: String,
)

fun NetworkUnsplashPhoto.asDomainModel(): UnsplashPhoto {
    return UnsplashPhoto(
        id = id,
        createdAt = createdAt,
        width = width,
        height = height,
        color = color,
        urls = urls.asDomainModel(),
        likes = likes,
        likedByUser = likedByUser,
        description = description,
        user = user.asDomainModel(),
    )
}

fun NetworkUnsplashPhotoUrls.asDomainModel(): UnsplashPhotoUrls {
    return UnsplashPhotoUrls(
        raw = raw,
        full = full,
        regular = regular,
        thumb = thumb,
        smallS3 = smallS3,
    )
}