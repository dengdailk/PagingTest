package com.dengdai.pagingtest.paging

import androidx.lifecycle.ViewModel
import com.dengdai.pagingtest.respository.GankRespository

class PagingWithNetWorkViewModel(private val gankRespository: GankRespository):ViewModel() {
    private val mData = gankRespository.getGank()

    val gankList = mData.pagedList
    val netWorkState = mData.networkState
    val refreshState = mData.refreshState

    fun refresh(){
        mData.refresh.invoke()
    }

    fun retry(){
        mData.retry.invoke()
    }
}