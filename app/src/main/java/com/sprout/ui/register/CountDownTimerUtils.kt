package com.sprout.ui.register;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.sprout.R;

/**
 * @data on 2020/10/16 6:26 PM
 * @auther armstrong
 * @describe 倒计时工具类
 */
public class CountDownTimerUtils extends CountDownTimer {
    private TextView mTextView;

    public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击
        mTextView.setText("重新发送("+millisUntilFinished / 1000 +")");  //设置倒计时时间
        mTextView.setBackgroundResource(R.drawable.shape_green_lucency_bk_10); //设置按钮为灰色，这时是不能点击的
        SpannableString spannableString = new SpannableString(mTextView.getText().toString());  //获取按钮上的文字
        ForegroundColorSpan span = new ForegroundColorSpan(Color.GRAY);
        spannableString.setSpan(span, 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时的时间设置为红色
        mTextView.setText(spannableString);
    }

    @Override
    public void onFinish() {
        mTextView.setText("获取短信验证码");
        mTextView.setClickable(true);//重新获得点击
        mTextView.setBackgroundResource(R.drawable.icon_wow_pay_send_button_normal);  //还原背景色
    }

}