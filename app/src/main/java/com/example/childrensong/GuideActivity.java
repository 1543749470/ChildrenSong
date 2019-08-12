package com.example.childrensong;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class GuideActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView guideImg;
    private Animation alphaAnimation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        guideImg = (ImageView) findViewById(R.id.guide_img);
        alphaAnimation = AnimationUtils.loadAnimation(this,
                R.anim.imageanima);
        alphaAnimation.setFillEnabled(true);//启动Fill保持
        alphaAnimation.setFillAfter(true);//设置动画的最后一帧是保留在view上的
        guideImg.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(this);
    }
    public boolean onKeyDown(int KeyCode, KeyEvent event){
        //在欢迎页面屏蔽BACK键
        if(KeyCode==KeyEvent.KEYCODE_BACK){
            return false;
        }
        return false;

    }


    @Override
    public void onAnimationStart(Animation animation) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                MediaPlayer mediaPlayer = MediaPlayer.create(GuideActivity.this, R.raw.ergedd_introduce);
                mediaPlayer.start();

            }
        },1500); // 延时1秒

        timer.cancel();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
       startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
