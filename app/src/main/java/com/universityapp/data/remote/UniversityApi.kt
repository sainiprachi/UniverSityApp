package com.universityapp.data.remote

import com.universityapp.model.University
import retrofit2.Response
import retrofit2.http.GET

interface UniversityApi {
    @GET("search?country=United%20Arab%20Emirates")
    suspend fun doNetworkCall(): Response<List<University>>
}