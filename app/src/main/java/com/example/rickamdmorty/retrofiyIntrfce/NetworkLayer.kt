package com.example.rickamdmorty.retrofiyIntrfce

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit =
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://rickandmortyapi.com/api/").build()

    val rickAndMortyService: RickAndMortyService by lazy { retrofit.create(RickAndMortyService::class.java) }

    val apiClient = ApiClient(rickAndMortyService)
}