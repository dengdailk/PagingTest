package com.dengdai.pagingtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dengdai.pagingtest.paging.PagingWithNetWorkActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openPaging.setOnClickListener {
            startActivity(Intent(this,PagingWithNetWorkActivity::class.java))
        }
    }
}