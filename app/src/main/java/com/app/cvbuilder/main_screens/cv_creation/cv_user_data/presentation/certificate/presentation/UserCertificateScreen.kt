package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.BottomNavigationArrows
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.domain.UserCertificate

@Preview
@Composable
fun UserCertificatesScreenPreview() {
    UserCertificatesScreen({}) {

    }
}

@Composable
fun UserCertificatesScreen(onNextButtonClick: () -> Unit, onPreviousButtonClick: () -> Unit) {
    CertificatesList(onNextButtonClick = onNextButtonClick)
}

@Composable
fun CertificatesList(
    modifier: Modifier = Modifier,
    onNextButtonClick: () -> Unit
) {
    val viewModel: UserCertificateViewModel = viewModel()
    val certificatesList = viewModel.certificatesList

    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = modifier
                .background(Color.White)
                .padding(horizontal = 20.dp)
                .fillMaxSize()
        ) {
            items(certificatesList.size) { index ->
                CertificateItem(
                    onUpdate = { updatedItem ->
                        viewModel.certificatesList[index] = updatedItem
                    }
                )
            }
        }
        BottomNavigationArrows(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isNextStepAllowed = false,
            onLeftButtonClick = {

            },
            onRightButtonClick = {

            }
        )
    }
}

@Composable
fun CertificateItem(
    modifier: Modifier = Modifier,
    onUpdate: (UserCertificate) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {

            val dateReceived = rememberSaveable { mutableStateOf("") }
            val certificateName = rememberSaveable { mutableStateOf("") }
            val certificateDetails = rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                value = dateReceived.value,
                onValueChange = {
                    dateReceived.value = it
                    onUpdate.invoke(
                        UserCertificate(
                            certificateName.value,
                            dateReceived.value,
                            certificateDetails.value
                        )
                    )
                },
                label = { Text("Date received") },
                maxLines = 1,
                placeholder = { Text("Type Date") },
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.width(200.dp)
            )
            OutlinedTextField(
                value = certificateName.value,
                onValueChange = {
                    certificateName.value = it
                    onUpdate.invoke(
                        UserCertificate(
                            certificateName.value,
                            dateReceived.value,
                            certificateDetails.value
                        )
                    )
                },
                label = { Text("Certificate title") },
                placeholder = { Text("Enter title") },
                maxLines = 3,
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = certificateDetails.value,
                onValueChange = {
                    certificateDetails.value = it
                    onUpdate.invoke(
                        UserCertificate(
                            certificateName.value,
                            dateReceived.value,
                            certificateDetails.value
                        )
                    )
                },
                label = { Text("Certificate details") },
                placeholder = { Text("Enter details") },
                maxLines = 5,
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}

@Composable
fun ButtonAddItem(onAddButtonClicked: () -> Unit) {
    IconButton(modifier = Modifier.fillMaxWidth(), onClick = {
        onAddButtonClicked.invoke()
    }) {
        Icon(
            modifier = Modifier,
            imageVector = Icons.Default.Add,
            contentDescription = "ButtonNext"
        )
    }
}