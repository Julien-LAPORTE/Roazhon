package fr.samneo.roazhonapp.controller

import fr.samneo.roazhonapp.data.DataSource
import fr.samneo.roazhonapp.model.AppModel
import fr.samneo.roazhonapp.model.PointOfInterest
import fr.samneo.roazhonapp.ui.components.getNextIndex
import fr.samneo.roazhonapp.ui.components.getPreviousIndex
import kotlinx.coroutines.flow.update

class AppViewModel : AppModel() {

    override fun updateCategory(category: DataSource.Category) {
        _uiState.update {
            it.copy(category = category)
        }
    }

    override fun updatePointOfInterest(pointOfInterest: PointOfInterest) {
        _uiState.update {
            it.copy(pointOfInterest = pointOfInterest)
        }
    }

    override fun getNextPhoto() {
        val photosListSize = uiState.value.pointOfInterest.photos.size
        val currentIndex = uiState.value.index
        val nextIndex = getNextIndex(photosListSize, currentIndex)
        _uiState.update {
            it.copy(index = nextIndex)
        }
    }

    override fun getPreviousPhoto() {
        val photoListSize = uiState.value.pointOfInterest.photos.size
        val currentIndex = uiState.value.index
        val previousIndex = getPreviousIndex(photoListSize, currentIndex)
        _uiState.update {
            it.copy(index = previousIndex)
        }
    }

    override fun showFullScreen() {
        _uiState.update {
            it.copy(isFullScreen = !it.isFullScreen)
        }
    }

}