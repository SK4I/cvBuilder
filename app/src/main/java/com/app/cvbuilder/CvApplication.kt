package com.app.cvbuilder

import android.app.Application
import androidx.room.Room
import com.app.cvbuilder.core.di.appModule
import com.app.cvbuilder.core.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CvApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
        private const val DATABASE_NAME = "cv_root_database"
    }

    override fun onCreate() {
        super.onCreate()
        initRoom()
        initKoin()
    }

    private fun initRoom() {
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@CvApplication)
            modules(appModule)
        }
    }
}