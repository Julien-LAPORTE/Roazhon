package fr.samneo.roazhonapp.ui

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fr.samneo.roazhonapp.R
import fr.samneo.roazhonapp.ui.components.SwipeableContent
import fr.samneo.roazhonapp.ui.theme.AppTheme

@Composable
fun PhotosWindow(
    @DrawableRes photo: Int,
    onSwipeLeft: () -> Unit,
    onSwipeRight: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackClick()
    }
    Box(modifier) {
        SwipeableContent(
            onSwipeLeft = onSwipeLeft, onSwipeRight = onSwipeRight, Modifier.align(
                Alignment.Center
            )
        ) {
            Image(
                painter = painterResource(id = photo), contentDescription = null
            )
        }
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.previous_screen)
            )
        }

    }
}

@Preview
@Composable
fun PhotosWindowPreview() {
    AppTheme {
        PhotosWindow(photo = R.drawable.restaurants_cafe_breton_01,
            onSwipeLeft = {},
            onSwipeRight = {},
            onBackClick = {})
    }
}