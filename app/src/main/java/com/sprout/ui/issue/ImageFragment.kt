package com.sprout.ui.issue

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.kotlinbase.ext.findView
import com.sprout.R
import com.sprout.model.ImgData
import kotlinx.android.synthetic.main.fragment_image.*

class ImageFragment(
    var index:Int,
    var path:String
): Fragment() {

    companion object{
        fun instance(i: Int, path: String, tags: MutableList<ImgData.Tag>): ImageFragment {
            return ImageFragment(i, path)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_image,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(path.isNotEmpty()){
            image.setImageURI(Uri.parse(path))
        }

    }

    /**
     * 添加标签到界面
     */
    fun addTagsToView(type:Int,id:Int,name:String){
        var view = layoutInflater.inflate(R.layout.layout_tag_item,null)
        var imgTag = view.findView<ImageView>(R.id.img_tag).value
        var txtName = view.findView<TextView>(R.id.txt_name).value
        txtName.setText(name)
        when(type){
            1-> imgTag.setImageResource(R.drawable.selector_photo_brand)
            2-> imgTag.setImageResource(R.drawable.selector_photo_commodity)
            3-> imgTag.setImageResource(R.drawable.selector_photo_user)
            4-> imgTag.setImageResource(R.drawable.selector_photo_location)
        }
        var param = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        param.setMargins(100,100,0,0) //控制组件的坐标位置
        layout_tags.addView(view,param)
    }

}