# Jetpack Compose UI Note
Compose로 구현한 UI 작업 노트입니다.

## 1. Compose Component Catalogs
Compose 컴포넌트를 사용한 UI 노트
- [Bottom Navigation](presentation/src/main/java/com/woogear/presentation/screen/category/compose/bottomnav/BottomNavScreen.kt)
  - Bottom Navigation 탭을 통해 페이지를 전환하는 UI
- [Top Tabs Navigation](presentation/src/main/java/com/woogear/presentation/screen/category/compose/toptabs/TopTabsWithColumnScreen.kt) 
  - 화면 상단의 탭을 클릭하면 해당 스크롤로 이동하며 반대로 스크롤 위치에 따라 탭도 상호 선택되는 UI 
- [Auto-sized Text](presentation/src/main/java/com/woogear/presentation/screen/category/compose/autosizingtext/AutoSizingTextrScreen.kt)
  - 주어진 화면의 크기에 따라 텍스트 크기를 줄여주는 UI
- [Sticky Header](presentation/src/main/java/com/woogear/presentation/screen/category/compose/stickyheader/StickyHeaderScreen.kt)
  - Sticky Header를 사용해 LazyColumn의 아이템 카테고리별로 표시해주는 UI
- [Paging Demo](presentation/src/main/java/com/woogear/presentation/screen/category/compose/paging/PagingDemoScreen.kt)
  - Paging3를 사용한 데모 UI 


## 2. Canvas Drawings
Canvas를 사용한 커스텀 UI 노트 
- [Chart UI](presentation/src/main/java/com/woogear/presentation/screen/category/canvas/chart/ChartScreen.kt) 
  - 3가지 형태의 차트를 표현할 수 있는 커스텀 차트 UI
- [Custom Progress](presentation/src/main/java/com/woogear/presentation/screen/category/canvas/progress/CustomProgressScreen.kt)
  - Progress를 애니메이션으로 나타내주는 원형 형태의 ProgressIndicator

## 3. Compose Examples
Compose를 사용한 간단한 앱 화면 노트
- [Unsplash](presentation/src/main/java/com/woogear/presentation/screen/category/example/unsplash/UnsplashPhotosScreen.kt) 
  - Unsplash API를 사용한 이미지 목록 UI 
- [Vertical Timline](presentation/src/main/java/com/woogear/presentation/screen/category/example/timeline/VerticalTimelineScreen.kt)
  - 일자별로 나열된 카드를 수직형태로 보여주는 타임라인 UI 