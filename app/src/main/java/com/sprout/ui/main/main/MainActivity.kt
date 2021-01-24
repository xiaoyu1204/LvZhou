package com.sprout.ui.main.main

import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentManager
import com.shop.base.BaseActivity
import com.sprout.R
import com.sprout.databinding.ActivityMainBinding
import com.sprout.ui.issue.IssueActivity
import com.sprout.viewmodel.main.MainViewModel

//TODO 绿洲搭建页面
class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>(
    R.layout.activity_main,MainViewModel::class.java
) , View.OnClickListener {

    private lateinit var mFm:FragmentManager

    override fun initView() {
        initClick()
        initFragment()
    }

    //TODO 点击事件
    private fun initClick() {
        mDataBinding.layoutHome.setOnClickListener(this)
        mDataBinding.layoutSearch.setOnClickListener(this)
        mDataBinding.layoutIssue.setOnClickListener(this)
        mDataBinding.layoutInfo.setOnClickListener(this)
        mDataBinding.layoutMe.setOnClickListener(this)
    }

    //TODO 监听
    override fun onClick(v: View?) {
        //开启事物
        val bs = mFm.beginTransaction()
        //重置所有属性
        resetImg()
        when(v?.id){
            //home
            R.id.layout_home -> {
                mDataBinding.ivMainHomeImg.setImageResource(R.drawable.main_nav_home_hl)
                bs.show(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(3))
            }
            //搜索
            R.id.layout_search -> {
                mDataBinding.ivMainSearchImg.setImageResource(R.drawable.main_nav_discover_hl)
                bs.show(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(3))
            }
            //加号
            R.id.layout_issue -> {
                val intent = Intent(this, IssueActivity::class.java)
                startActivity(intent)
            }
            //消息
            R.id.layout_info -> {
                mDataBinding.ivMainInfoImg.setImageResource(R.drawable.main_nav_message_hl)
                bs.show(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(3))
            }
            //我的
            R.id.layout_me -> {
                mDataBinding.ivMainMeImg.setImageResource(R.drawable.main_nav_mine_hl)
                bs.show(mViewModel.fragments.get(3))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(0))
            }
        }
        bs.commit()
    }

    //TODO 重置所有属性
    private fun resetImg() {
        mDataBinding.ivMainHomeImg.setImageResource(R.drawable.main_nav_home_normal)
        mDataBinding.ivMainSearchImg.setImageResource(R.drawable.main_nav_discover_normal)
        mDataBinding.ivMainInfoImg.setImageResource(R.drawable.main_nav_message_normal)
        mDataBinding.ivMainMeImg.setImageResource(R.drawable.main_nav_mine_normal)
    }

    //TODO fragment管理器
    private fun initFragment() {
        mFm = supportFragmentManager

        //放入布局管理器
        mFm.beginTransaction()
            .add(R.id.mRl_main, mViewModel.fragments.get(0))
            .add(R.id.mRl_main, mViewModel.fragments.get(1))
            .add(R.id.mRl_main, mViewModel.fragments.get(2))
            .add(R.id.mRl_main, mViewModel.fragments.get(3))
            .hide(mViewModel.fragments.get(1))
            .hide(mViewModel.fragments.get(2))
            .hide(mViewModel.fragments.get(3))
            .commit();//提交事物

    }

    override fun initVM() {
    }

    override fun initData() {
    }

    override fun initVariable() {
    }



}