package com.universityapp.data.remote.repository

import com.universityapp.data.remote.UniversityApi
import com.universityapp.domain.repository.UniversityRepository
import com.universityapp.model.University
import retrofit2.Response

class UniversityRepositoryImplementation(
    private val api : UniversityApi
): UniversityRepository {
    override suspend fun doNetworkCal() : Response<List<University>> {
        return api.doNetworkCall()
    }
}