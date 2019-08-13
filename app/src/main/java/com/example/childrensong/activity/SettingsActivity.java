package com.example.childrensong.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.childrensong.R;
import com.example.childrensong.base.SimpleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends SimpleActivity {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static void start(Context context) {
        if (context != null) {
            Intent it = new Intent(context, SettingsActivity.class);
            context.startActivity(it);
        }
    }
    @Override
    protected void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbarTitle.setText("设置");
        toolbar.setNavigationIcon(R.drawable.icon_common_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_settings;
    }


}
