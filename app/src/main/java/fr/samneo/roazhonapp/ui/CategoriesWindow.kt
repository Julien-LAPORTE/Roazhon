package fr.samneo.roazhonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fr.samneo.roazhonapp.R
import fr.samneo.roazhonapp.data.DataSource
import fr.samneo.roazhonapp.ui.theme.AppTheme
import fr.samneo.roazhonapp.ui.theme.Shapes

@Composable
fun CategoriesWindow(onCategoryClick: (DataSource.Category)-> Unit,modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = Modifier.weight(1f))
        CategoryItemList(
            categories = DataSource.Category.values().toList(), onCategoryClick, modifier = modifier
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun CategoryItemList(
    categories: List<DataSource.Category>,
    onCategoryClick: (DataSource.Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(categories) {
            CategoryItem(
                category = it, onCategoryClick, Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: DataSource.Category,
    onCategoryClick: (DataSource.Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.clickable { onCategoryClick(category) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Surface(shape = Shapes.small) {
            Image(
                painter = painterResource(id = category.picture), null, Modifier.size(
                    dimensionResource(id = R.dimen.recommendation_size_picture)
                ), contentScale = ContentScale.Crop
            )
        }
        Text(
            text = stringResource(id = category.title), modifier = Modifier.padding(
                start = dimensionResource(
                    id = R.dimen.padding_medium
                )
            ), style = MaterialTheme.typography.displayMedium
        )
    }
}

@Preview
@Composable
fun CategoriesWindowPreview() {
    AppTheme {
        CategoriesWindow({})
    }
}

@Preview
@Composable
fun CategoryItemListPreview() {
    AppTheme {
        CategoryItemList(DataSource.Category.values().toList(), {})
    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    AppTheme {
        CategoryItem(DataSource.Category.RESTAURANTS, {})
    }
}