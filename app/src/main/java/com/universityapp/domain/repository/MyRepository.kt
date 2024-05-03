package com.universityapp.domain.repository

import com.universityapp.model.University
import retrofit2.Response

interface MyRepository {
    suspend fun doNetworkCal() : Response<List<University>>

}