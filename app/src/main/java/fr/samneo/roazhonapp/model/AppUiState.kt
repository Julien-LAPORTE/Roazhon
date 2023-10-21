package fr.samneo.roazhonapp.model

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import fr.samneo.roazhonapp.data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AppUiState(
    val category: DataSource.Category = DataSource.Category.RESTAURANTS,
    val pointOfInterest: PointOfInterest = DataSource.getRecommendations(category)[0],
    val index: Int = 0,
    val isFullScreen: Boolean = false
)

abstract class AppModel : ViewModel() {
    protected val _uiState = MutableStateFlow(AppUiState())
    val uiState = _uiState.asStateFlow()

    abstract fun updateCategory(category: DataSource.Category)
    abstract fun updatePointOfInterest(pointOfInterest: PointOfInterest)
    abstract fun getNextPhoto()
    abstract fun getPreviousPhoto()
    abstract fun showFullScreen()
}
