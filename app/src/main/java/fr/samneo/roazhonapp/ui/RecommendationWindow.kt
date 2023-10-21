package fr.samneo.roazhonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import fr.samneo.roazhonapp.R
import fr.samneo.roazhonapp.data.DataSource
import fr.samneo.roazhonapp.model.PointOfInterest
import fr.samneo.roazhonapp.ui.theme.AppTheme


@Composable
fun RecommendationWindows(
    category: DataSource.Category,
    onRecommendationClick: (PointOfInterest) -> Unit,
    modifier: Modifier = Modifier
) {
    RecommendationsItemList(category = category, onRecommendationClick)
}

@Composable
fun RecommendationsItemList(
    category: DataSource.Category,
    onRecommendationClick: (PointOfInterest) -> Unit,
    modifier: Modifier = Modifier
) {

    val recommendations = DataSource.getRecommendations(category)

    LazyColumn(modifier) {
        items(recommendations) {
            RecommendationItem(
                pointOfInterest = it,
                onRecommendationClick,
                Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun RecommendationItem(
    pointOfInterest: PointOfInterest,
    onRecommendationClick: (PointOfInterest) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.clickable { onRecommendationClick(pointOfInterest) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = pointOfInterest.photos[0]),
            contentDescription = null,
            alignment = Alignment.Center
        )
        Text(
            text = pointOfInterest.name,
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun RecommendationWindowsPreview() {
    AppTheme {
        RecommendationWindows(category = DataSource.Category.RESTAURANTS, {})
    }
}

@Preview
@Composable
fun RecommendationItemListPreview() {
    AppTheme {
        RecommendationsItemList(category = DataSource.Category.RESTAURANTS, {})
    }
}

@Preview
@Composable
fun RecommendationItemPreview() {
    val pointOfInterest = DataSource.getRecommendations(DataSource.Category.RESTAURANTS)[0]
    AppTheme {
        RecommendationItem(pointOfInterest = pointOfInterest, {})
    }
}