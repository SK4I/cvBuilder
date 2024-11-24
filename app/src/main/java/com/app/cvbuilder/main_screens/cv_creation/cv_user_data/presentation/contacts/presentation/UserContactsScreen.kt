package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.cvbuilder.core.utils.AndroidResourceProvider
import com.app.cvbuilder.core.utils.toContactTitle
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.domain.ContactItem
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.domain.ContactType

@Composable
fun UserContactsScreen(onNextButtonClick: () -> Unit, onPreviousButtonClick: () -> Unit) {

    val viewModel: UserContactsViewModel = viewModel()

    LazyColumn {
        items(viewModel.contactTypesList.size) { index: Int ->
            UserContactItem(
                type = viewModel.contactTypesList[index].contactType,
                onUpdate = { updatedItem ->
                    viewModel.contactTypesList[index] = updatedItem
                })
        }
    }
}

@Composable
fun UserContactItem(
    modifier: Modifier = Modifier,
    type: ContactType,
    onUpdate: (ContactItem) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        val contactValue = rememberSaveable { (mutableStateOf("")) }
        OutlinedTextField(
            modifier = modifier.fillMaxSize(),
            value = contactValue.value,
            onValueChange = {
                contactValue.value = it
                onUpdate.invoke(ContactItem(type, contactValue.value))
            },
            maxLines = 1,
            label = {
                Text(type.toContactTitle(resourceProvider = AndroidResourceProvider(context = LocalContext.current)))
            }
        )
    }
}