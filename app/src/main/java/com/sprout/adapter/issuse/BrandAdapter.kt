package com.sprout.ui.more.adapter

import android.content.Context
import android.util.SparseArray
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.example.kotlinbase.model.bean.issue.IssueBrandData
import com.example.kotlinbase.model.myitem.IItemClick
import com.example.myshop.base.BaseAdapter
import com.sprout.BR
import com.sprout.R

/**
 * 品牌的adapter
 */
class BrandAdapter(
        context: Context,
        list:List<IssueBrandData.Data>,
        layouts:SparseArray<Int>,
        var click: IItemClick<IssueBrandData.Data>
): BaseAdapter<IssueBrandData.Data>(context,list,layouts,click) {
    override fun bindData(binding: ViewDataBinding, data: IssueBrandData.Data, layId: Int) {
        binding.setVariable(BR.brandItemClick,click)
        var txt = binding.root.findViewById<TextView>(R.id.txt_name)
        txt.setText(data.name)
    }

    override fun layoutId(position: Int): Int {
        return R.layout.layout_brand_item
    }
}