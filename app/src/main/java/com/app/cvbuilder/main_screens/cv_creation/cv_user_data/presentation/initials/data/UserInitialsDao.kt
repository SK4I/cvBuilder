package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserInitialsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInitials(userInitials: UserInitials)

    @Query("SELECT * FROM user_initials")
    suspend fun getUserInitials(): List<UserInitials>
}