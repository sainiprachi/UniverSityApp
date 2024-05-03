package com.universityapp.data.remote.db

import android.app.Application
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.universityapp.model.University
import com.universityapp.util.Converter
import dagger.hilt.android.HiltAndroidApp

@TypeConverters(Converter::class)


@Database(entities = [University::class], version = 1,exportSchema = false)

abstract class UniversityDB : RoomDatabase() {


 abstract fun getUniversityDao() : UniversityDAO


}