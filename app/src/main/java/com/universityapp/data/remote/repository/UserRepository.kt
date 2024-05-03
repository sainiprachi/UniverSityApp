package com.universityapp.data.remote.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.universityapp.data.remote.db.UniversityDAO
import com.universityapp.model.University
import javax.inject.Inject

 class UserRepository @Inject constructor(
    private val universityDAO: UniversityDAO
) {

    fun getAllUniversity(): List<University> {
        return universityDAO.getUniversity()
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addUniversity(universities: List<University>) {
    }

 }
