package com.woogear.presentation.screen.category.compose.paging

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.woogear.presentation.screen.category.compose.paging.model.BibleName
import com.woogear.presentation.screen.category.compose.paging.model.MockNames
import com.woogear.presentation.screen.category.compose.paging.model.PagingDemoData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class PagingDemoViewModel(
    private val repository: PagingDemoRepository = PagingDemoRepository()
) : ViewModel() {
    val demoPagesFlow: Flow<PagingData<BibleName>> = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
            initialLoadSize = PAGE_SIZE * 2,
            enablePlaceholders = false,
        ),
        pagingSourceFactory = {
            DemoPagingSource(repository)
        }
    ).flow

    companion object {
        const val PAGE_SIZE = 20
    }
}

class PagingDemoRepository {
    suspend fun getPage(
        pageIndex: Int,
        loadSize: Int,
    ): PagingDemoData {
        delay(1500L)
        return MockNames.getPages(loadSize)[pageIndex]
    }
}

class DemoPagingSource(
    private val repository: PagingDemoRepository
) : PagingSource<Int, BibleName>() {

    override fun getRefreshKey(state: PagingState<Int, BibleName>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BibleName> {
        val pageIndex = params.key ?: INITIAL_PAGE
        val result = repository.getPage(pageIndex, params.loadSize)

        return LoadResult.Page(
            data = result.names,
            prevKey = if (pageIndex == INITIAL_PAGE) null else pageIndex - 1,
            nextKey = if (result.hasNext) pageIndex + 1 else null
        )
    }

    companion object {
        const val INITIAL_PAGE = 1
    }
}