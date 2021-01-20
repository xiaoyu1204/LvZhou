package com.sprout.ui.register

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import com.sprout.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //加载数据
        initView()
    }

    fun initView(){
        //设置播放加载路径
        //videoview_register.setVideoPath( Environment.getExternalStorageDirectory() + "/Pictures/boy.mp4" )
        //播放
//        videoview_register.start()
//        //循环播放
//        videoview_register.setOnCompletionListener {
//            videoview_register.start()
//        }
        //富文本
//        Spannable()
    }

    fun Spannable(){
        val string = tv_register_text.text.toString()
        //起始位置
        var startPos = string.indexOf( " " )
        //结束位置
        var endPos = string.indexOf( "|" )
        val spannableString = SpannableString(string)
        spannableString.setSpan( ForegroundColorSpan( Color.parseColor( "#FF9800" ) ), startPos+1, endPos, Spanned.SPAN_INCLUSIVE_INCLUSIVE );//设置EZ的背景色
        spannableString.setSpan( ForegroundColorSpan( Color.parseColor( "#FF9800" ) ), endPos+1,spannableString.length , Spanned.SPAN_INCLUSIVE_INCLUSIVE );//设置EZ前景色，也就是字体颜色
        tv_register_text.setText( spannableString )
    }


}