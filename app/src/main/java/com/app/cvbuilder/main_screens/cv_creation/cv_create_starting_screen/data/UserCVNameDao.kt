package com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserCVNameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserCVName(userCVName: UserCVName)

    @Query("SELECT * FROM user_cv_name")
    fun getCVName(): List<UserCVName>
}