package com.example.rickamdmorty

import com.example.rickamdmorty.retrofiyIntrfce.GetCharacterByIdResponse
import com.example.rickamdmorty.retrofiyIntrfce.NetworkLayer

class SharedRepository {

    suspend fun getCharacterById(characterID: Int): GetCharacterByIdResponse?{
        val request = NetworkLayer.apiClient.getCharacterById(characterID)

        if(request.isSuccessful){
            return request.body()!!
        }

        return null
    }
}