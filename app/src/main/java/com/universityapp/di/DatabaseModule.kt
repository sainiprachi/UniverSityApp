package com.universityapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.universityapp.data.remote.db.UniversityDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {
    @Singleton
    @Provides
    @ApplicationContext
    fun provideUniversityDB(context: Context): UniversityDB {
        return Room.databaseBuilder(context, UniversityDB::class.java, "UniversityDB").build()
    }

}