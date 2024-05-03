package com.universityapp.data.remote.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universityapp.model.University
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn


@Dao
@Module
@InstallIn

interface UniversityDAO {

    @Binds
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addUniversity(universities: List<University>)

     @Binds
     @Query("SELECT * FROM UniversityTable")
    fun getUniversity() : List<University>


    @Provides
    fun getUniversity(universityDAO: UniversityDAO): List<University?>? {
        return universityDAO.getUniversity()
    }

}