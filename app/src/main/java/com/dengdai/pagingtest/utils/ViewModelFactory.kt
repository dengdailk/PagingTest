package com.dengdai.pagingtest.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dengdai.pagingtest.paging.PagingWithNetWorkViewModel
import com.dengdai.pagingtest.respository.GankRespository


/**
 * @author Hankkin
 * @date 2019-05-30
 */
class ViewModelFactory(
    private val gankRespository: GankRespository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(PagingWithNetWorkViewModel::class.java) -> {
                    PagingWithNetWorkViewModel(gankRespository)
                }
                else ->
                    throw IllegalArgumentException("Unknown ViewModel: ${modelClass.name}")
            }

        } as T


    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                    Injection.provideGankRespository()
                )
            }
    }
}