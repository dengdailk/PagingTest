package com.dengdai.pagingtest.ext

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.dengdai.pagingtest.R
import com.dengdai.pagingtest.utils.StatusBarUtil
import com.dengdai.pagingtest.utils.ViewModelFactory


fun AppCompatActivity.setupToolBar(toolbar: Toolbar, action: ActionBar.() -> Unit) {
    toolbar.setTitleTextColor(resources.getColor(R.color.black))
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        action()
    }
}

fun AppCompatActivity.setLightMode(){
    StatusBarUtil.setLightMode(this)
}

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, application?.let { ViewModelFactory.getInstance(it) }).get(viewModelClass)