package com.woogear.presentation.screen.category.example.unsplash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.woogear.domain.model.UnsplashPhoto
import com.woogear.domain.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnsplashPhotosViewModel @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {

    private val loadingFlow = MutableStateFlow(false)
    private val photosFlow = MutableStateFlow<List<UnsplashPhoto>>(emptyList())

    val uiStateFlow = combine(
        loadingFlow,
        photosFlow
    ) { loading, photos ->
        UnsplashPhotosUiState(
            loading = loading,
            photos = photos,
        )

    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = UnsplashPhotosUiState()
    )

    init {
        getPhotos()
    }

    private fun getPhotos() = viewModelScope.launch {
        try {
            val photos = unsplashRepository.getPhotos()
            photosFlow.emit(photos)
        } catch (e: Exception) {
            println(e.stackTraceToString())
        }
    }
}

data class UnsplashPhotosUiState(
    val loading: Boolean = false,
    val photos: List<UnsplashPhoto> = emptyList()
)
