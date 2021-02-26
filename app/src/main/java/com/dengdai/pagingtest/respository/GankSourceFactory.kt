package com.dengdai.pagingtest.respository

import androidx.lifecycle.MutableLiveData
import com.dengdai.pagingtest.data.bean.Gank
import com.dengdai.pagingtest.data.net.Api
import com.dengdai.pagingtest.utils.Injection

import androidx.paging.DataSource

class GankSourceFactory(private val api: Api = Injection.privideApi()):DataSource.Factory<Int, Gank>() {
    val sourceLiveData = MutableLiveData<GankDataSource>()
    override fun create(): DataSource<Int, Gank> {
        val source = GankDataSource(api)
        sourceLiveData.postValue(source)
        return source
    }


}