package com.sprout.ui.issue

import android.util.Log
import android.util.SparseArray
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinbase.model.bean.issue.IssueBrandData
import com.example.kotlinbase.model.bean.issue.IssueGoodData
import com.example.kotlinbase.model.myitem.IItemClick
import com.shop.base.BaseActivity
import com.sprout.BR
import com.sprout.R
import com.sprout.adapter.issuse.GoodAdapter
import com.sprout.databinding.ActivityTagsBinding
import com.sprout.ui.more.adapter.BrandAdapter
import com.sprout.viewmodel.main.issue.TagsViewModel
import kotlinx.android.synthetic.main.activity_tags.*

class TagsActivity : BaseActivity<TagsViewModel,ActivityTagsBinding>(R.layout.activity_tags,TagsViewModel::class.java),
    View.OnClickListener {

    lateinit var brandList:MutableList<IssueBrandData.Data>
    lateinit var brandAdapter:BrandAdapter

    lateinit var goodList:MutableList<IssueGoodData.Data>
    lateinit var goodAdapter: GoodAdapter

    override fun initView() {

        initClick()

        recyTags.layoutManager = LinearLayoutManager(this)

        var brandArr = SparseArray<Int>()
        brandArr.put(R.layout.layout_brand_item,BR.brandData)
        brandList = mutableListOf()
        brandAdapter = BrandAdapter(this,brandList,brandArr,BrandClick())


        var goodArr = SparseArray<Int>()
        goodArr.put(R.layout.layout_good_item,BR.goodData)
        goodList = mutableListOf()
        goodAdapter = GoodAdapter(this,goodList,goodArr,GoodClick())

    }

    private fun initClick() {
        mDataBinding.imgBrand.setOnClickListener(this)
        mDataBinding.imgGood.setOnClickListener(this)
        mDataBinding.imgUser.setOnClickListener(this)
        mDataBinding.imgAddress.setOnClickListener(this)
    }

    override fun initVM() {
        mViewModel.bList.observe(this, Observer {
            brandList.clear()
            brandList.addAll(it.data)
            recyTags.adapter = brandAdapter
        })

        mViewModel.gList.observe(this, Observer {
            goodList.clear()
            goodList.addAll(it.data)
            recyTags.adapter = goodAdapter
        })

    }

    inner class BrandClick:IItemClick<IssueBrandData.Data>{
        override fun itemClick(data: IssueBrandData.Data) {
            intent.putExtra("name",data.name)
            intent.putExtra("id",data.id)
            setResult(1,intent)
            finish()
        }
    }

    inner class GoodClick:IItemClick<IssueGoodData.Data>{
        override fun itemClick(data: IssueGoodData.Data) {
            intent.putExtra("name",data.name)
            intent.putExtra("id",data.id)
            setResult(2,intent)
            finish()
        }

    }


    override fun initData() {
    }

    override fun initVariable() {
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.img_brand -> {
                if(brandList.size == 0){
                    mViewModel.getBrand()
                }else{
                    recyTags.adapter = brandAdapter
                }
            }
            R.id.img_good -> {
                if(goodList.size == 0){
                    mViewModel.getGood()
                }else{
                    recyTags.adapter = goodAdapter
                }
            }
            R.id.img_user -> {

            }
            R.id.img_address -> {

            }
        }
    }


}