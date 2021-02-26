package com.dengdai.pagingtest.data.net

import com.dengdai.pagingtest.data.bean.GankResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("data/Android/{count}/{page}")
    fun getGank(
        @Path("count") count:Int,
        @Path("page") page:Int
    ): Call<GankResponse>
}