package com.sprout.adapter.issuse

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.example.kotlinbase.model.bean.issue.IssueGoodData
import com.example.kotlinbase.model.myitem.IItemClick
import com.example.myshop.base.BaseAdapter
import com.sprout.BR
import com.sprout.R

/**
 * 商品的adapter
 */
class GoodAdapter(
    context: Context,
    list:List<IssueGoodData.Data>,
    layouts: SparseArray<Int>,
    var click: IItemClick<IssueGoodData.Data>
): BaseAdapter<IssueGoodData.Data>(context,list,layouts,click) {
    override fun bindData(binding: ViewDataBinding, data: IssueGoodData.Data, layId: Int) {
        binding.setVariable(BR.goodclick,click)
    }

    override fun layoutId(position: Int): Int {
        return R.layout.layout_good_item
    }
}