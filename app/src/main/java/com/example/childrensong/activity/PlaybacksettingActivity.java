package com.example.childrensong.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.childrensong.R;
import com.example.childrensong.base.SimpleActivity;
import com.zcw.togglebutton.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaybacksettingActivity extends SimpleActivity {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_playback_one)
    ToggleButton btnPlaybackOne;
    @BindView(R.id.btn_playback_two)
    ToggleButton btnPlaybackTwo;

    @Override
    protected void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbarTitle.setText("播放设置");
        toolbar.setNavigationIcon(R.drawable.icon_common_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnPlaybackOne.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on){
                    showdialog();
                }else {

                }
            }
        });



    }
   public void showdialog(){
       TextView textView = new TextView(this);
       textView.setText("      2G/3G/4G网络播放会产生较多流量,确定使用");
       new AlertDialog.Builder(this).setTitle("提醒")
               .setView(textView)
               .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               btnPlaybackOne.toggle();   //点击取消返回  按钮为flase
           }
       }).show();
   }
    @Override
    protected int createLayout() {
        return R.layout.activity_playbacksetting;
    }


}
