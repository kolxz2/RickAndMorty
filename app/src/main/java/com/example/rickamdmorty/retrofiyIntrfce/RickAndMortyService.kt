package com.example.rickamdmorty.retrofiyIntrfce

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("character/{character_id}")
    suspend fun getChapterByID(@Path("character_id") characterId:Int): Response<GetCharacterByIdResponse>
}