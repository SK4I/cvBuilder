package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserPhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserPhoto(userPhoto: UserPhoto)

    @Query("SELECT * FROM user_photo")
    suspend fun getUserPhoto(): List<UserPhoto>
}