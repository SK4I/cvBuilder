package com.app.cvbuilder.main_screens.cv_creation.cv_templates_screen.presentation

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.cvbuilder.core.ui.theme.RedColor
import com.app.cvbuilder.main_screens.cv_creation.cv_templates_screen.domain.TemplateItem
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.CVCreationScaffold
import com.app.cvbuilder.navigation.CVTemplates
import com.github.theapache64.twyper.Twyper
import com.github.theapache64.twyper.rememberTwyperController
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt

@Preview
@Composable
fun CVTemplatesScreenPreview() {
    CVTemplatesScreen({}) { }
}

@Composable
fun CVTemplatesScreen(onNextButtonClicked: () -> Unit, onPreviousButtonClick: () -> Unit) {
    CVCreationScaffold(
        sectionTitle = "Templates",
        content = { TemplateCard() },
        onNextButtonClick = onNextButtonClicked,
        onPreviousButtonClick = onPreviousButtonClick
    )
}

@Composable
private fun TemplateCard() {
    val items = remember {
        mutableStateListOf(
            TemplateItem(imageUrl = Uri.EMPTY, title = "11"),
            TemplateItem(imageUrl = Uri.EMPTY, title = "22"),
            TemplateItem(imageUrl = Uri.EMPTY, title = "33"),
            TemplateItem(imageUrl = Uri.EMPTY, title = "44")
        )
    }

    val twyperController = rememberTwyperController()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Twyper(
            items = items,
            twyperController = twyperController, // optional
            onItemRemoved = { item, direction ->
                println("Item removed: $item -> $direction")
                items.remove(item)
            },
            onEmpty = {
                println("End reached")
            }
        ) { item ->
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .width(300.dp)
                    .background(RedColor),
                contentAlignment = Alignment.Center
            ) {
                Text(item.title)
            }
        }
    }
}