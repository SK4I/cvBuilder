package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.app.cvbuilder.R
import com.app.cvbuilder.core.ui.theme.PrimaryColorLight
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.CVCreationScaffold
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.KoinPreview
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.domain.UserPersonalInfoField
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.domain.UserPersonalInfoSectionType
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.toUserDataFlowSettings
import org.koin.androidx.compose.koinViewModel

@Composable
@Preview
fun PersonalInfoScreenPreview() {
    KoinPreview {
        PersonalInfoScreen({}) {}
    }
}

@Composable
fun PersonalInfoScreen(onNextButtonClicked: () -> Unit, onPreviousButtonClick: () -> Unit) {
    CVCreationScaffold(
        sectionTitle = "Personal Info",
        content = { PersonalInfo() },
        onNextButtonClick = onNextButtonClicked,
        onPreviousButtonClick = onPreviousButtonClick
    )
}

@Composable
private fun PersonalInfo() {

    val viewModel: UserPersonalInfoViewModel = koinViewModel()
    val infoFieldsList = remember{ viewModel.userPersonalInfoFieldsList }

    Column(
        modifier = Modifier.toUserDataFlowSettings(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfilePicture()
        Column {
            infoFieldsList.filter { it.sectionType == UserPersonalInfoSectionType.Main }
                .forEach { item ->
                    TextInput(item) { updatedItem ->
                        viewModel.onUserPersonalInfoFieldUpdated(updatedItem)
                    }
                }
        }
        Text(text = "Contact Info", modifier = Modifier.padding(top = 8.dp))
        Column {
            infoFieldsList.filter { it.sectionType == UserPersonalInfoSectionType.ContactInfo }
                .forEach { item ->
                    TextInput(item) { updatedItem ->
                        viewModel.onUserPersonalInfoFieldUpdated(updatedItem)
                    }
                }
        }
        Text(text = "Address", modifier = Modifier.padding(top = 8.dp))
        Column {
            infoFieldsList.filter { it.sectionType == UserPersonalInfoSectionType.Address }
                .forEach { item ->
                    TextInput(item) { updatedItem ->
                        viewModel.onUserPersonalInfoFieldUpdated(updatedItem)
                    }
                }
        }
    }
}

@Composable
private fun TextInput(
    item: UserPersonalInfoField,
    onTextValueUpdated: (UserPersonalInfoField) -> Unit
) {

    val textValue = remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = PrimaryColorLight
            )
            .height(56.dp),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextValueUpdated(item.copy(value = textValue.value))
        },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
        ),
        label = {
            Text(
                style = TextStyle(fontSize = 12.sp),
                text = item.title
            )
        },
        placeholder = { Text("Input") },
    )
}

@Composable
private fun ProfilePicture() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = PrimaryColorLight, shape = RoundedCornerShape(50.dp))
    ) {
        Image(
            painter = rememberAsyncImagePainter(R.drawable.ic_content_copy),
            contentDescription = "Rounded Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}