package com.example.rickamdmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.rickamdmorty.databinding.ActivityMainBinding
import com.example.rickamdmorty.retrofiyIntrfce.GetCharacterByIdResponse
import com.example.rickamdmorty.retrofiyIntrfce.RickAndMortyService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    val viewModel : SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.refreshCharacter(54)
        viewModel.characterByIdLiveData.observe(this){response ->
            if (response == null){
                Toast.makeText(
                    this@MainActivity,
                    "Unsuccessful network call !",
                    Toast.LENGTH_LONG)
                    .show()
                return@observe
            }
            binding.characterName.text = response.name
            binding.alive.text = response.status
            binding.SpeciesApi.text = response.species
            binding.originAPI.text = response.origin.name
            if(response.gender.equals("male", true)){
                binding.gender.setImageResource(R.drawable.ic_male_24)
            } else{
                binding.gender.setImageResource(R.drawable.ic_female_24)
            }

            Picasso.get().load(response.image).into(binding.characterIcon)

        }
            }
}