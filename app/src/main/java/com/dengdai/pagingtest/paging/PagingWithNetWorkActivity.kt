package com.dengdai.pagingtest.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.dengdai.pagingtest.R
import com.dengdai.pagingtest.data.NetworkState
import com.dengdai.pagingtest.databinding.ActivityPagingWithNetWorkBinding
import com.dengdai.pagingtest.ext.obtainViewModel
import com.dengdai.pagingtest.ext.setLightMode
import com.dengdai.pagingtest.ext.setupToolBar

class PagingWithNetWorkActivity : AppCompatActivity() {
    private lateinit var mViewModel: PagingWithNetWorkViewModel
    private lateinit var mDataBinding:ActivityPagingWithNetWorkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_paging_with_net_work)
        setLightMode()
        setupToolBar(mDataBinding.toolbar.toolbar){
            title = "Paging测试"
            setDisplayHomeAsUpEnabled(true)
        }

        mViewModel = obtainViewModel(PagingWithNetWorkViewModel::class.java)

        mDataBinding.vm = mViewModel
        mDataBinding.lifecycleOwner = this

        val adapter = PagingWithNetWorkAdapter()
        mDataBinding.rvPagingWithNetwork.adapter = adapter
        mDataBinding.vm?.gankList?.observe(this, Observer { adapter.submitList(it) })
        mDataBinding.vm?.refreshState?.observe(this, Observer {
            mDataBinding.rvPagingWithNetwork.post {
                mDataBinding.swipeRefresh.isRefreshing = it == NetworkState.LOADING
            }
        })

        mDataBinding.vm?.netWorkState?.observe(this, Observer {
            adapter.setNetworkState(it)
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}