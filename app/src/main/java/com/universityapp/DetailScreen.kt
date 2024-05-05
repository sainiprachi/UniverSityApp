package com.universityapp

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.universityapp.databinding.DetailsScreenBinding


class DetailScreen :AppCompatActivity() {
    private var _binding : DetailsScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DetailsScreenBinding.inflate(layoutInflater)
        val view = _binding!!.root
        setContentView(view)
        //Here details of university is showing
        binding.tvUniversityName.text=intent?.getStringExtra("name")
        if (!intent?.getStringExtra("state").equals(""))
            binding.tvState.visibility=View.GONE
        else
            binding.tvState.visibility=View.VISIBLE
        binding.tvState.text=intent?.getStringExtra("state")
        binding.tvCountry.text=intent?.getStringExtra("country")
        binding.tvCountryCode.text=intent?.getStringExtra("countryCode")
        binding.tvWebpage.text=intent?.getStringArrayListExtra("domains")?.get(0)
        binding.imageView.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        onBackPressedDispatcher.addCallback(this /* lifecycle owner */, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Back is pressed... Finishing the activity
                finish()
            }
        })
    }






    }



