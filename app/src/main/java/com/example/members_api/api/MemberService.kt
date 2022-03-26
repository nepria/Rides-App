package com.example.members_api.api

import com.example.members_api.model.Rides
import retrofit2.Response
import retrofit2.http.GET

interface MemberService {
    @GET("/rides")
    suspend fun getMembers(
    ): Response<Rides>

}