package com.universityapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.universityapp.databinding.ActivityMainBinding
import com.universityapp.model.University
import com.universityapp.util.Network
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var universityListAdapter: UniversityListAdapter
    private lateinit var universityList : List<University>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding!!.root
        setContentView(view)
        val viewModel:MainViewModel by viewModels()

        if (Network.checkConnectivity(this@MainActivity)){
            viewModel.getUniversityViewModel()

            viewModel.universityList.observe(this , Observer {
                universityList= it.body()!!
                Log.d("MainActivity" ,  "This is the response list ${it.body()}")

            })
        }


        else{
            universityList=viewModel.getAllUsers()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        universityListAdapter = UniversityListAdapter(universityList,
            UniversityListAdapter.OnClickListener { item ->


            })
        binding.recyclerView.adapter=universityListAdapter








    }


}