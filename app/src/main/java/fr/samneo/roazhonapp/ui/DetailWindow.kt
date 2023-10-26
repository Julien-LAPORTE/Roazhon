package fr.samneo.roazhonapp.ui

import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.samneo.roazhonapp.R
import fr.samneo.roazhonapp.data.DataSource
import fr.samneo.roazhonapp.model.PointOfInterest
import fr.samneo.roazhonapp.ui.theme.AppTheme
import fr.samneo.roazhonapp.ui.utils.ContentType

@Composable
fun DetailWindow(
    contentType: ContentType,
    pointOfInterest: PointOfInterest,
    indexPhotos: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onFullScreenClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    when (contentType) {
        ContentType.LIST_ONLY -> {
            Column(
                modifier = modifier.verticalScroll(state = scrollState, enabled = true),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Pictures(
                    photo = pointOfInterest.photos[indexPhotos],
                    onPreviousClick = onPreviousClick,
                    onNextClick = onNextClick,
                    onFullScreenClick = onFullScreenClick,
                    pictureSize = R.dimen.detail_size_picture_small_device
                )
                Spacer(Modifier.weight(0.25f))
                Divider()
                Description(
                    description = pointOfInterest.description, modifier = Modifier.padding(
                        start = dimensionResource(
                            id = R.dimen.padding_medium
                        ), end = dimensionResource(id = R.dimen.padding_medium)
                    )
                )
                Divider()
                Spacer(modifier = Modifier.weight(1f))
            }
        }

        ContentType.LIST_AND_CONTENT -> {
            Row(modifier = modifier) {
                Pictures(
                    photo = pointOfInterest.photos[indexPhotos],
                    onPreviousClick = onPreviousClick,
                    onNextClick = onNextClick,
                    onFullScreenClick = onFullScreenClick,
                    pictureSize = R.dimen.detail_size_picture_extended_device,
                )
                Description(
                    description = pointOfInterest.description, modifier = Modifier.padding(
                        dimensionResource(id = R.dimen.padding_small)
                    )
                )
            }
        }
    }

}

@Composable
fun Pictures(
    @DrawableRes photo: Int,
    @DimenRes pictureSize: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onFullScreenClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Box {
            Surface(shadowElevation = 10.dp, color = MaterialTheme.colorScheme.background) {
                Image(
                    painter = painterResource(id = photo),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = pictureSize))
                )
            }
            IconButton(
                onClick = onFullScreenClick, modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_open_in_full_black_24),
                    stringResource(id = R.string.fullscreen),
                    tint = Color.Red
                )
            }
        }
        Row {
            Button(onClick = onPreviousClick) {
                Text(stringResource(id = R.string.previous))
            }
            //Spacer(modifier = Modifier.weight(1f))
            Button(onClick = onNextClick) {
                Text(stringResource(id = R.string.next))
            }
        }
    }

}

@Composable
fun Description(@StringRes description: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = description),
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Preview(showBackground = true)
@Composable
fun DetailWindowPreview() {
    val pointOfInterest = DataSource.getRecommendations(DataSource.Category.PARKS)[3]
    AppTheme {
        DetailWindow(contentType = ContentType.LIST_ONLY,
            pointOfInterest = pointOfInterest,
            0,
            onPreviousClick = {},
            onNextClick = {},
            onFullScreenClick = {})
    }
}

@Preview
@Composable
fun PicturesPreview() {
    val photo = DataSource.getRecommendations(DataSource.Category.RESTAURANTS)[0].photos[0]
    AppTheme {
        Pictures(photo = photo,
            onPreviousClick = {},
            onNextClick = {},
            onFullScreenClick = {},
            pictureSize = R.dimen.detail_size_picture_small_device
        )
    }
}

@Preview
@Composable
fun DescriptionPreview() {
    val description = DataSource.getRecommendations(DataSource.Category.RESTAURANTS)[0].description
    Description(description)

}