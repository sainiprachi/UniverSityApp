package com.universityapp.data.remote.repository

import com.universityapp.data.remote.MyApi
import com.universityapp.domain.repository.MyRepository
import com.universityapp.model.University
import retrofit2.Response

class MyRepositoryImplementation(
    private val api : MyApi
): MyRepository {
    override suspend fun doNetworkCal() : Response<List<University>> {
        return api.doNetworkCall()
    }
}