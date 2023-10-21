package fr.samneo.roazhonapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class PointOfInterest(
    open val name: String,
    @StringRes open val description: Int,
    @DrawableRes open val photos: List<Int>
) {
    data class Restaurant(
        override val name: String,
        @StringRes override val description: Int,
        @DrawableRes override val photos: List<Int>
    ) : PointOfInterest(name, description, photos)

    data class CoffeeShop(
        override val name: String,
        @StringRes override val description: Int,
        @DrawableRes override val photos: List<Int>
    ) : PointOfInterest(name, description, photos)

    data class Park(
        override val name: String,
        @StringRes override val description: Int,
        @DrawableRes override val photos: List<Int>
    ) : PointOfInterest(name, description, photos)

    data class Mall(
        override val name: String,
        @StringRes override val description: Int,
        @DrawableRes override val photos: List<Int>
    ) : PointOfInterest(name, description, photos)

    data class GasStation(
        override val name: String,
        @StringRes override val description: Int,
        @DrawableRes override val photos: List<Int>
    ) : PointOfInterest(name, description, photos)

    data class Gym(
        override val name: String,
        @StringRes override val description: Int,
        @DrawableRes override val photos: List<Int>
    ) : PointOfInterest(name, description, photos)
}
