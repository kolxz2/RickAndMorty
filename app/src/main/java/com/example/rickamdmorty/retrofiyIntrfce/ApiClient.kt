package com.example.rickamdmorty.retrofiyIntrfce

import retrofit2.Response

class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {
    suspend fun getCharacterById(characterId: Int): SimpleResponse<GetCharacterByIdResponse> {
        return  safeApiCall{rickAndMortyService.getChapterByID(characterId)}
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>):SimpleResponse<T>{
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: java.lang.Exception){
            SimpleResponse.failure(e)
        }
    }
}