package fr.samneo.roazhonapp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.samneo.roazhonapp.R
import fr.samneo.roazhonapp.controller.AppViewModel
import fr.samneo.roazhonapp.ui.utils.ContentType

enum class AppWindow {
    CATEGORY,
    RECOMMENDATIONS,
    DETAIL,
    PHOTOS
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    canNavigateUp: Boolean, title: String, navigateUp: () -> Unit, modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(
                            id = R.string.previous_screen
                        )
                    )
                }
            }
        },
    )
}

@Composable
fun MainWindow(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val appViewModel: AppViewModel = viewModel()
    val uiState by appViewModel.uiState.collectAsState()
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Expanded -> ContentType.LIST_AND_CONTENT
        else -> ContentType.LIST_ONLY
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val title: String = when (backStackEntry?.destination?.route ?: AppWindow.CATEGORY.name) {
        AppWindow.CATEGORY.name -> stringResource(id = R.string.city_name)
        AppWindow.RECOMMENDATIONS.name -> stringResource(id = uiState.category.title)
        AppWindow.DETAIL.name -> uiState.pointOfInterest.name
        else -> stringResource(id = R.string.app_name)
    }

    Scaffold(
        topBar = {
            if (!uiState.isFullScreen) {
                AppTopBar(
                    canNavigateUp = navController.previousBackStackEntry != null,
                    title = title,
                    navigateUp = { navController.navigateUp() },
                )
            }
        },
    ) { paddingValue ->

        NavHost(
            navController = navController,
            contentType = contentType,
            categoriesWindow = {
                CategoriesWindow(
                    onCategoryClick = {
                        appViewModel.updateCategory(it)
                        if (contentType == ContentType.LIST_ONLY) navController.navigate(
                            AppWindow.RECOMMENDATIONS.name
                        )
                    },
                )
            },
            recommendationWindow = {
                RecommendationWindows(
                    category = uiState.category,
                    onRecommendationClick = { pointOfInterest ->
                        appViewModel.updatePointOfInterest(pointOfInterest)
                        navController.navigate(AppWindow.DETAIL.name)
                    },
                )
            },
            detailWindow = {
                DetailWindow(
                    contentType = contentType,
                    pointOfInterest = uiState.pointOfInterest,
                    indexPhotos = uiState.index,
                    onPreviousClick = { appViewModel.getPreviousPhoto() },
                    onNextClick = { appViewModel.getNextPhoto() },
                    onFullScreenClick = {
                        appViewModel.showFullScreen()
                        navController.navigate(AppWindow.PHOTOS.name)
                    },
                )
            },
            photosWindow = {
                PhotosWindow(
                    photo = uiState.pointOfInterest.photos[uiState.index],
                    onSwipeLeft = {
                        appViewModel.getNextPhoto()
                    },
                    onSwipeRight = {
                        appViewModel.getPreviousPhoto()
                    },
                    onBackClick = {
                        appViewModel.showFullScreen()
                        navController.popBackStack()
                    },
                )
            },
            modifier = modifier.padding(paddingValue),
        )
    }

}

@Composable
fun NavHost(
    navController: NavHostController,
    contentType: ContentType,
    categoriesWindow: @Composable () -> Unit,
    recommendationWindow: @Composable () -> Unit,
    detailWindow: @Composable () -> Unit,
    photosWindow: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController, startDestination = AppWindow.CATEGORY.name, modifier = modifier
    ) {
        composable(AppWindow.CATEGORY.name) {
            when (contentType) {
                ContentType.LIST_ONLY -> {
                    categoriesWindow()
                }

                ContentType.LIST_AND_CONTENT -> {
                    Row {
                        categoriesWindow()
                        recommendationWindow()
                    }
                }
            }
        }
        composable(AppWindow.RECOMMENDATIONS.name) {
            when (contentType) {
                ContentType.LIST_ONLY -> {
                    recommendationWindow()
                }

                ContentType.LIST_AND_CONTENT -> {
                    Row {
                        categoriesWindow()
                        recommendationWindow()
                    }
                }
            }
        }

        composable(AppWindow.DETAIL.name) {
            detailWindow()
        }
        composable(AppWindow.PHOTOS.name) {
            photosWindow()
        }
    }
}