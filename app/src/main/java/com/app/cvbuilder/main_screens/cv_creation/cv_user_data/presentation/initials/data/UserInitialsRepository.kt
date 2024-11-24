package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data

import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Error
import com.app.cvbuilder.core.domain.Result

interface UserInitialsRepository {
    suspend fun updateUserInitials(userInitials: UserInitials): Result<UserInitials, DataError.Local>
}