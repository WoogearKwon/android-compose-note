package com.woogear.presentation.screen.category.example.unsplash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.woogear.domain.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnsplashViewModel @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {

    init {
        getRandomPhotos()
    }

    private fun getRandomPhotos() = viewModelScope.launch {

    }
}
