package com.universityapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universityapp.data.remote.db.UniversityDB
import com.universityapp.data.remote.repository.UserRepository
import com.universityapp.domain.repository.MyRepository
import com.universityapp.model.University
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MyRepository,
    private val userRepository: UserRepository,


) : ViewModel() {

    val universityList: MutableLiveData<Response<List<University>>> = MutableLiveData()
    private val _universities = MutableLiveData<List<University>>() // private member only

    fun getAllUsers(): List<University> {
        return userRepository.getAllUniversity()
    }

    private fun insertUser(universities: List<University>) {
        userRepository.addUniversity(universities)
    }


    fun getUniversityViewModel() {
        viewModelScope.launch {
            Log.d("University", "From universityViewModel")
            universityList.value = repository.doNetworkCal()
            insertDataLocalDB(repository.doNetworkCal())


        }
    }

    private suspend fun insertDataLocalDB(value: Response<List<University>>) {
        val universityList: List<University>? = value.body()!!
        universityList?.let { insertUser(it) }
        //universityList?.let { universityDb.getUniversityDao().addUniversity(it) }

    }

    /*fun getDataFromLocalDb(): List<University> {
        val universityList: List<University>?
        //universityList = universityDb.getUniversityDao().getUniversity()
        return universityList;

    }*/


}