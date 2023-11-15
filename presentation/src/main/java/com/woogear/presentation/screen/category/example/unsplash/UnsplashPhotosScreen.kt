package com.woogear.presentation.screen.category.example.unsplash

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.woogear.presentation.R

@Composable
fun UnsplashPhotosScreen(
    modifier: Modifier = Modifier,
    viewModel: UnsplashPhotosViewModel,
    onClickExit: () -> Unit,
) {
    val uiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onClickExit.invoke() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(text = stringResource(R.string.unsplash_images_title))
                }
            )
        },
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(it),
            columns = GridCells.Fixed(2)
        ) {
            items(uiState.photos) { photo ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .height(150.dp)
                        .clickable { },
                    elevation = 10.dp,
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = rememberAsyncImagePainter(photo.urls.thumb),
                        contentDescription = null
                    )
                }
            }
        }
    }
}
