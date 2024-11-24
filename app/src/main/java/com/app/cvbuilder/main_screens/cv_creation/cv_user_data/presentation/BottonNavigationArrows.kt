package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.app.cvbuilder.R
import com.app.cvbuilder.core.ui.theme.PrimaryColorLight

@Preview
@Composable
fun BottomNavigationArrowsPreview() {
    BottomNavigationArrows(onLeftButtonClick = {}, onRightButtonClick = {})
}

@Composable
fun BottomNavigationArrows(
    modifier: Modifier = Modifier,
    isNextStepAllowed: Boolean = false,
    onLeftButtonClick: () -> Unit,
    onRightButtonClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(PrimaryColorLight)
    ) {
        NavigationButton(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onLeftButtonClick()
                },
            getIconDrawable = { R.drawable.ic_arrow_back },
            getIconText = { "Previous" }
        )
        NavigationButton(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onRightButtonClick()
                },
            getIconDrawable = { R.drawable.ic_arrow_forward },
            getIconText = { "Continue" }
        )
    }
}

@Composable
private fun NavigationButton(
    modifier: Modifier,
    @DrawableRes getIconDrawable: () -> Int,
    getIconText: () -> String
) {
    Column(modifier = modifier) {
        Icon(
            modifier = Modifier
                .weight(1f)
                .size(24.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(getIconDrawable()),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.CenterHorizontally),
            text = getIconText()
        )
    }
}