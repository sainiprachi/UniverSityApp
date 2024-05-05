package com.universityapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universityapp.domain.repository.UniversityRepository
import com.universityapp.model.University
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UniversityRepository,
    ) : ViewModel() {

    val universityList: MutableLiveData<Response<List<University>>> = MutableLiveData()

    /*Fetching Data from server via retrofit and for background implementation coroutine used*/
    fun getUniversityViewModel() {
        viewModelScope.launch {
            Log.d("University", "From universityViewModel")
            universityList.value = repository.doNetworkCal()


        }
    }





}