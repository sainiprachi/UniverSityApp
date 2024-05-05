package com.universityapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.universityapp.UniversityListAdapter.OnClickListener
import com.universityapp.databinding.ActivityMainBinding
import com.universityapp.model.University
import com.universityapp.util.Network
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiViews()

    }

  fun  initialiViews(){
      _binding = ActivityMainBinding.inflate(layoutInflater)
      val view = _binding!!.root
      setContentView(view)
      //Getting Data from viewModel
      val viewModel: MainViewModel by viewModels()
      viewModel.getUniversityViewModel()
      viewModel.universityList.observe(this, Observer {
          Toast.makeText(this, "" + it.body(), Toast.LENGTH_LONG).show();
          binding.recyclerView.layoutManager = LinearLayoutManager(this)
          binding.recyclerView.adapter =
              it.body()?.let { it1 ->
                  UniversityListAdapter(it1, OnClickListener { item ->
                      val intent=Intent(this,DetailScreen::class.java)
                      intent.putExtra("name",item.name)
                      intent.putExtra("state",item.stateProvince)
                      intent.putExtra("country",item.country)
                      intent.putExtra("countryCode",item.alphaTwoCode)
                      intent.putStringArrayListExtra("domains",item.domains)
                      startActivity(intent)
                  })
              }


      })
  }


}