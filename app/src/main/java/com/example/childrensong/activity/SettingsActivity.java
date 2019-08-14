package com.example.childrensong.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.childrensong.R;
import com.example.childrensong.base.SimpleActivity;
import com.example.childrensong.utils.Constants;
import com.example.childrensong.utils.TrackUtil;
import com.example.childrensong.utils.ZZListDialog;
import com.zcw.togglebutton.ToggleButton;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends SimpleActivity {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.partner)
    LinearLayout partner;
    @BindView(R.id.search_recommend)
    LinearLayout searchRecommend;
    @BindView(R.id.btn_circle_one)
    ToggleButton btnCircleOne;
    @BindView(R.id.btn_circle_two)
    ToggleButton btnCircleTwo;
    @BindView(R.id.morning)
    LinearLayout morning;
    @BindView(R.id.sleep)
    LinearLayout sleep;
    @BindView(R.id.morning_time)
    TextView morningTime;
    @BindView(R.id.viewOne)
    View viewOne;
    @BindView(R.id.sleep_time)
    TextView sleepTime;
    @BindView(R.id.viewTwo)
    View viewTwo;
    private ZZListDialog ToastUtils;
    private String pv = "setting";



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

        initOne();
        initMorning();
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_settings;
    }


    @OnClick({R.id.partner, R.id.search_recommend, R.id.morning, R.id.sleep})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.partner:
                startActivity(new Intent(this, PartnerActivity.class));
                break;
            case R.id.search_recommend://分享推荐
                break;
            default:
                break;
        }
    }

    private void initMorning() {

        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> itemList = new ArrayList<String>();
                List<String> valueList = new ArrayList<String>();

                itemList.add("06:00");
                itemList.add("06:30");
                itemList.add("07:00");
                itemList.add("07:30");
                itemList.add("08:00");
                itemList.add("08:30");
                itemList.add("09:00");

              valueList.add(String.valueOf(Constants.HOUR_TIME * 6));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 6 + Constants.MIN_TIME * 30));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 7));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 7 + Constants.MIN_TIME * 30));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 8));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 8 + Constants.MIN_TIME * 30));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 9));

                ZZListDialog.DialogOnItemClickLister listener = new ZZListDialog.DialogOnItemClickLister() {
                    @Override
                    public void onClick(int index, String value) {
                        long longValue = Long.valueOf(value);
                        String valueText =ConvertLongTimeToString(longValue);
                        Toast.makeText(SettingsActivity.this, "起床时间已更新: "+valueText, Toast.LENGTH_SHORT).show();
                        TrackUtil.trackEvent(pv, "time.getup", valueText, 1);
                        morningTime.setText(valueText);
                        //Preferences.getPreferences(SettingsActivity.this).setGetUpTime(longValue);
                    }
                };
                ZZListDialog dialog = new ZZListDialog(SettingsActivity.this, "选择起床时间", itemList, valueList, listener);
                dialog.show();
            }
        });
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> itemList = new ArrayList<String>();
                List<String> valueList = new ArrayList<String>();

                itemList.add("20:00");
                itemList.add("20:30");
                itemList.add("21:00");
                itemList.add("21:30");
                itemList.add("22:00");
                itemList.add("22:30");
                itemList.add("23:00");
                itemList.add("23:30");
                itemList.add("24:00");


                valueList.add(String.valueOf(Constants.HOUR_TIME * 20));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 20 + Constants.MIN_TIME * 30));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 21));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 21 + Constants.MIN_TIME * 30));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 22));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 22 + Constants.MIN_TIME * 30));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 23));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 23 + Constants.MIN_TIME * 30));
                valueList.add(String.valueOf(Constants.HOUR_TIME * 24 - 1));

                ZZListDialog.DialogOnItemClickLister listener = new ZZListDialog.DialogOnItemClickLister() {
                    @Override
                    public void onClick(int index, String value) {
                        long longValue = Long.valueOf(value);
                        String valueText = ConvertLongTimeToString(longValue);
                        Toast.makeText(SettingsActivity.this, "睡觉时间已更新: "+valueText, Toast.LENGTH_SHORT).show();
                        TrackUtil.trackEvent(pv, "time.sleep", valueText, 1);
                        sleepTime.setText(valueText);
                    //    Preferences.getPreferences(mActivity).setSleepTime(longValue);
                    }
                };

                ZZListDialog dialog = new ZZListDialog(SettingsActivity.this, "选择睡觉时间", itemList, valueList, listener);
                dialog.show();
            }
        });
    }

    public static String ConvertLongTimeToString(long time) {
        StringBuilder sb = new StringBuilder();

        long min = time / Constants.MIN_TIME % 60;
        long hour = time / Constants.HOUR_TIME;

        if (hour < 10)
            sb.append("0");
        sb.append(hour).append(":");

        if (min < 10)
            sb.append("0");
        sb.append(min);

        return sb.toString();
    }
    private static final String TAG = "SettingsActivity";

    private void initOne() {

        //开关切换事件
        btnCircleTwo.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    morning.setVisibility(View.VISIBLE);
                    sleep.setVisibility(View.VISIBLE);
                    viewOne.setVisibility(View.VISIBLE);
                    viewTwo.setVisibility(View.VISIBLE);
                } else {
                    morning.setVisibility(View.GONE);
                    sleep.setVisibility(View.GONE);
                    viewOne.setVisibility(View.GONE);
                    viewTwo.setVisibility(View.GONE);
                }
            }
        });


    }


}
