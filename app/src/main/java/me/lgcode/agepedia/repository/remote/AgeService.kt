package me.lgcode.agepedia.repository.remote

import retrofit2.Response
import retrofit2.http.GET

interface AgeService {

    @GET("civilizations")
    suspend fun getCivs(): Response<CivResponseWrapper>

}