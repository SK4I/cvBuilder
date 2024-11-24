package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.presentation

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data.UserPhoto
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.presentation.ButtonNext
import kotlinx.coroutines.launch

@Preview
@Composable
fun ChoosePhotoScreenPreview() {
    UserChoosePhotoScreen({}) {

    }
}

@Composable
fun UserChoosePhotoScreen(onNextButtonClicked: () -> Unit, onPreviousButtonClick: () -> Unit) {

    val viewModel: UserChoosePhotoViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()

    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val pickImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
        coroutineScope.launch {
            viewModel.onUserPhotoUpdated(UserPhoto(uri = uri.toString()))
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {

        val buttonNextModifier = remember {
            Modifier
                .align(Alignment.End)
                .size(80.dp)
        }
        val choosePhotoTitleTextModifier =
            remember {
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(200.dp)
            }

        Image(
            modifier = Modifier
                .clickable {
                    pickImageLauncher.launch("image/*")
                }
                .size(200.dp)
                .align(Alignment.CenterHorizontally),
            painter = rememberAsyncImagePainter(
                if (imageUri == null) {
                    rememberAsyncImagePainter(Icons.Default.AccountCircle)
                } else {
                    rememberAsyncImagePainter(imageUri)
                }
            ),
            contentDescription = "ButtonNext",
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = choosePhotoTitleTextModifier,
            text = "Choose Photo",
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        ButtonNext(buttonNextModifier, onNextButtonClicked)
    }
}