package com.woogear.presentation.screen.category.compose.paging.model

object MockNames {
    val pages get() = listOf(
        generateMock(1, true),
        generateMock(2, true),
        generateMock(3, true),
        generateMock(4, true),
        generateMock(5, true),
        generateMock(6, true),
        generateMock(7, true),
        generateMock(8, false),
    )

    private fun generateMock(
        page: Int,
        hasNext: Boolean
    ): PagingDemoData {
        return PagingDemoData(
            names = listOf(
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
                BibleName(),
            ),
            page = page,
            hasNext = hasNext
        )
    }
}