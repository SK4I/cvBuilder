package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun UserCompaniesScreenPreview() {
    UserCompaniesScreen({}) { }
}

@Composable
fun UserCompaniesScreen(onNextButtonClick: () -> Unit, onPreviousButtonClick: () -> Unit) {
    val viewModel: UserCompaniesViewModel = viewModel()

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 20.dp)
            .fillMaxSize()
    ) {
        items(viewModel.companyList.size) { index: Int ->
            CompanyItem(onUpdate = { updatedItem ->
                viewModel.companyList[index] = updatedItem
            })
        }
    }
}

@Composable
fun CompanyItem(
    modifier: Modifier = Modifier,
    onUpdate: (CompanyItem) -> Unit
) {

    val dateStarted = rememberSaveable { mutableStateOf("") }
    val dateEnded = rememberSaveable { mutableStateOf("") }
    val companyName = rememberSaveable { mutableStateOf("") }
    val position = rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .height(400.dp)
            .fillMaxWidth()
    ) {

        OutlinedTextField(
            value = companyName.value,
            onValueChange = {
                companyName.value = it
                onUpdate.invoke(
                    CompanyItem(
                        companyName.value,
                        dateStarted.value,
                        dateEnded.value,
                        position.value
                    )
                )
            },
            label = { Text("Company Name") },
            maxLines = 2,
            placeholder = { Text("Type Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = dateStarted.value,
                onValueChange = {
                    dateStarted.value = it
                    onUpdate.invoke(
                        CompanyItem(
                            companyName.value,
                            dateStarted.value,
                            dateEnded.value,
                            position.value
                        )
                    )
                },
                label = { Text("Start date") },
                maxLines = 1,
                placeholder = { Text("Type date") },
                modifier = Modifier.weight(1F)
            )
            OutlinedTextField(
                value = dateEnded.value,
                onValueChange = {
                    dateEnded.value = it
                    onUpdate.invoke(
                        CompanyItem(
                            companyName.value,
                            dateStarted.value,
                            dateEnded.value,
                            position.value
                        )
                    )
                },
                label = { Text("End date") },
                maxLines = 1,
                placeholder = { Text("Type date") },
                modifier = Modifier.weight(1F)
            )
        }
        OutlinedTextField(
            value = position.value,
            onValueChange = {
                position.value = it
                onUpdate.invoke(
                    CompanyItem(
                        companyName.value,
                        dateStarted.value,
                        dateEnded.value,
                        position.value
                    )
                )
            },
            label = { Text("Position") },
            maxLines = 2,
            placeholder = { Text("Type Position") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

data class CompanyItem(
    val title: String,
    val dateStarted: String,
    val dateEnded: String,
    val position: String
) {
    companion object {
        fun empty(): CompanyItem {
            return CompanyItem("", "", "", "")
        }
    }
}
