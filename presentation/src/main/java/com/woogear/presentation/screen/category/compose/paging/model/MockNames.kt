package com.woogear.presentation.screen.category.compose.paging.model

object MockNames {
    private var pages: List<PagingDemoData>? = null

    fun getPages(size: Int): List<PagingDemoData> {
        return if (pages != null) pages as List<PagingDemoData> else listOf(
            generateMock(1, size, true),
            generateMock(2, size, true),
            generateMock(3, size, true),
            generateMock(4, size, true),
            generateMock(5, size, true),
            generateMock(6, size, true),
            generateMock(7, size, true),
            generateMock(8, size, false),
        )
    }

    private fun generateMock(
        page: Int,
        pageSize: Int,
        hasNext: Boolean,
    ): PagingDemoData {
        val list = mutableListOf<BibleName>()

        for (i in 1..pageSize) {
            list.add(BibleName())
        }

        return PagingDemoData(
            names = list,
            page = page,
            hasNext = hasNext
        )
    }
}