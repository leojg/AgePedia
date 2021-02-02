package me.lgcode.agepedia.repository.remote

import retrofit2.Response
import retrofit2.http.GET

interface TechService {

    @GET("technologies")
    suspend fun getTechs(): Response<TechResponseWrapper>

}