package com.dengdai.pagingtest.utils

import com.dengdai.pagingtest.data.net.Api
import com.dengdai.pagingtest.data.net.HttpClient
import com.dengdai.pagingtest.respository.GankRespository

object Injection {
    fun provideGankRespository() = GankRespository.getInstance()
    fun privideApi(): Api = HttpClient.instance
}