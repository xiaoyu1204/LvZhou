package com.sprout.ui.issue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinbase.model.myitem.IItemClick
import com.example.kotlinbase.utils.GlideEngine
import com.google.gson.Gson
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.shop.base.BaseActivity
import com.sprout.BR
import com.sprout.R
import com.sprout.adapter.issuse.SubmitImgAdapter
import com.sprout.databinding.ActivitySubmitMoreBinding
import com.sprout.model.ImgData
import com.sprout.viewmodel.main.issue.SubmitViewModel
import kotlinx.android.synthetic.main.activity_submit_more.*
import org.json.JSONArray

/**
 * 动态数据的提交
 */
class SubmitMoreActivity : BaseActivity<SubmitViewModel,ActivitySubmitMoreBinding>(R.layout.activity_submit_more,SubmitViewModel::class.java) ,
    OnClickListener{

    var imgs:MutableList<ImgData> = mutableListOf()
    var max_img = 12

    lateinit var imgAdapter: SubmitImgAdapter

    override fun initView() {
        var layouts = SparseArray<Int>()
        layouts.put(R.layout.layout_submit_imgitem, BR.submitData)
        imgAdapter = SubmitImgAdapter(mContext,imgs,layouts,subclick())
        recyImgs.layoutManager = GridLayoutManager(mContext,3)
        recyImgs.adapter = imgAdapter
        imgAdapter.clickEvt = SubmitClickEvt()

        //点击监听
        mDataBinding.submitImgAddimg.setOnClickListener(this)

    }

    override fun initVM() {
    }

    override fun initData() {
        var json = intent.getStringExtra("data")
        if(json!!.isNotEmpty()){
            var jsonArr = JSONArray(json)
            for(i in 0 until jsonArr.length()){
                var imgData = Gson().fromJson<ImgData>(jsonArr.getString(i),ImgData::class.java)
                imgs.add(imgData)
            }
            //处理加号
            if(imgs.size < max_img){
                var imgData = ImgData(null, mutableListOf())
                imgs.add(imgData)
            }
        }
    }

    override fun initVariable() {
    }

    private fun openPhoto(){
        //当前还能插入的图片数量
        var num = max_img-imgs.size+1
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofImage())
            .loadImageEngine(GlideEngine.createGlideEngine()) // Please refer to the Demo GlideEngine.java
            .maxSelectNum(num)
            .imageSpanCount(3)
            .selectionMode(PictureConfig.MULTIPLE)
            .forResult(PictureConfig.CHOOSE_REQUEST)
    }

    /**
     * 打开activity后回传
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            PictureConfig.CHOOSE_REQUEST -> {
                // onResult Callback
                val selectList = PictureSelector.obtainMultipleResult(data)
                if (selectList.size == 0) return
                //获取本地图片的选择地址，上传到服务器
                //头像的压缩和二次采样
                //把选中的图片插入到列表
                for(i in 0 until selectList.size){
                    var imgData = ImgData(selectList.get(i).path, mutableListOf())
                    var index = imgs.size-1
                    imgs.add(index,imgData)
                }
                if(imgs.size > max_img){
                    imgs.removeLast()
                    submit_img_addimg!!.visibility = View.GONE
                }
                imgAdapter.notifyDataSetChanged()
            }

            else -> {
            }
        }
    }

    /**
     * item条目的点击
     */
    inner class subclick: IItemClick<ImgData> {
        override fun itemClick(data: ImgData) {
            Log.e("TAG", "itemClick: "+"加号外" )
            //当前点击的是加号
//            if(data.path.isNullOrBlank()){
////            if(data.path.isNullOrEmpty()){
//                Log.e("TAG", "itemClick: "+"加号内" )
//                openPhoto()
//            }
        }
    }

//    inner class subAdd{
//        fun clickAdd(data:ImgData){
//            openPhoto()
//        }
//    }

    inner class SubmitClickEvt{
        fun clickDelete(data:ImgData){
            imgs.remove(data)
            imgAdapter.notifyDataSetChanged()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.submit_img_addimg -> {
                Log.e("TAG", "onClick: "+"submit_img_addimg" )
                openPhoto()
            }
            R.id.edit_title -> {
                Log.e("TAG", "onClick: "+"edit_title" )
            }
        }
    }

}