# Jetpack Compose UI Note
Compose로 구현한 UI 작업 노트입니다.

## 1. Compose Component Catalogs
Compose 컴포넌트를 사용한 UI 노트
- [Bottom Navigation](presentation/src/main/java/com/woogear/presentation/screen/category/compose/bottomnav/BottomNavScreen.kt) - Bottom Navigation 탭을 통해 페이지를 전환하는 UI
- [Top Tabs Navigation](presentation/src/main/java/com/woogear/presentation/screen/category/compose/toptabs/TopTabsWithColumnScreen.kt) 
  - 화면 상단의 탭을 클릭하면 해당 스크롤로 이동하며 반대로 스크롤 위치에 따라 탑도 선택되는 UI 
- [Auto-sized Text](presentation/src/main/java/com/woogear/presentation/screen/category/compose/autosizingtext/AutoSizingTextrScreen.kt)
  - 주어진 화면의 크기에 따라 텍스트 크기를 줄여주는 UI, 화면이 좁아 텍스트가 모두 표현될 수 없을 때 사용하기 좋음
- [Sticky Header](presentation/src/main/java/com/woogear/presentation/screen/category/compose/stickyheader/StickyHeaderScreen.kt)
    - LazyColumn 아이템


## 2. Canvas Drawings
Canvas를 사용한 커스텀 UI 노트 
- [Chart UI](presentation/src/main/java/com/woogear/presentation/screen/category/canvas/chart/ChartScreen.kt) - 3가지 형태의 차트를 표현할 수 있는 커스텀 차트 UI

## 3. Compose Examples
Compose를 사용한 간단한 앱 화면 노트
- [Unsplash](presentation/src/main/java/com/woogear/presentation/screen/category/example/unsplash/UnsplashPhotosScreen.kt) - Unsplash API를 사용한 이미지 목록 UI 