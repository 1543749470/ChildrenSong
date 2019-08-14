package com.example.childrensong.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.childrensong.R;
import com.example.childrensong.base.SimpleActivity;
import com.example.childrensong.utils.Constants;
import com.example.childrensong.utils.TrackUtil;
import com.example.childrensong.utils.ZZListDialog;
import com.zcw.togglebutton.ToggleButton;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.sex_onclick)
    LinearLayout sexOnclick;
    @BindView(R.id.frequency_text)
    TextView frequencyText;
    @BindView(R.id.frequency)
    LinearLayout frequency;
    @BindView(R.id.PlayerSettings)
    LinearLayout PlayerSettings;
    @BindView(R.id.management)
    LinearLayout management;
    private ZZListDialog ToastUtils;
    private String pv = "setting";
    private String nan;
    private AlertDialog alertDialog;


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


    @OnClick({R.id.partner, R.id.search_recommend, R.id.morning, R.id.sleep, R.id.sex_onclick, R.id.PlayerSettings,R.id.management})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.partner:
                startActivity(new Intent(this, PartnerActivity.class));
                break;
            case R.id.search_recommend://分享推荐
                initshare();
                break;
            case R.id.sex_onclick:
                // showSexChooseDialog();
                showDialog();
                break;
            case R.id.PlayerSettings:
                startActivity(new Intent(SettingsActivity.this, PlaybacksettingActivity.class));
                break;
            case R.id.management:
                startActivity(new Intent(SettingsActivity.this, ManagementActivity.class));
                break;
            default:
                break;
        }
    }

    private void initshare() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_type_url,getString(R.string.app_name),"海量儿歌故事，早教育儿必备", "http://a.app.qq.com/o/simple.jsp?pkgname=com.mampod.ergedd"));
        intent.setType("text/plain");
        startActivity(intent);
    }


    private void showDialog() {
        View inflate = View.inflate(this, R.layout.sex_dialog, null);
        Button sex_close = inflate.findViewById(R.id.sex_close);
        final Button sex_ok = inflate.findViewById(R.id.sex_ok);
        final TextView nanboby = inflate.findViewById(R.id.nanboby);
        final TextView girlboby = inflate.findViewById(R.id.girlboby);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // create alert dialog


        // 使用setView()方法将布局显示到dialog
        alertDialogBuilder.setView(inflate);
        final boolean[] ischecked = {false};
        nanboby.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (ischecked[0]) {
                    sex_ok.setBackgroundColor(R.color.Grey300);
                    ischecked[0] = false;
                } else {
                    sex_ok.setBackgroundColor(R.color.colorPrimary);
                    nan = nanboby.getText().toString();
                    ischecked[0] = true;

                }
            }
        });
        girlboby.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (ischecked[0]) {
                    sex_ok.setBackgroundColor(R.color.Grey300);
                    ischecked[0] = false;
                } else {
                    sex_ok.setBackgroundColor(R.color.colorPrimary);
                    nan = girlboby.getText().toString();
                    ischecked[0] = true;

                }
            }
        });
        sex_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ischecked[0] == true) {
                    sex.setText(nan);
                    alertDialog.cancel();
                } else {
                    sex_ok.setOnClickListener(null);
                }
            }
        });
        sex_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
        alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();


    }


    private String[] sexArry = new String[]{"女", "男"};// 性别选择

    private void showSexChooseDialog() {
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);// 自定义对话框
        builder3.setSingleChoiceItems(sexArry, 0, new DialogInterface.OnClickListener() {// 2默认的选中

            @Override
            public void onClick(DialogInterface dialog, int which) {// which是被选中的位置
                // showToast(which+"");
                sex.setText(sexArry[which]);
                dialog.dismiss();// 随便点击一个item消失对话框，不用点击确认取消
            }
        });
        builder3.show();// 让弹出框显示
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
                        String valueText = ConvertLongTimeToString(longValue);
                        Toast.makeText(SettingsActivity.this, "起床时间已更新: " + valueText, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(SettingsActivity.this, "睡觉时间已更新: " + valueText, Toast.LENGTH_SHORT).show();
                        TrackUtil.trackEvent(pv, "time.sleep", valueText, 1);
                        sleepTime.setText(valueText);
                        //    Preferences.getPreferences(mActivity).setSleepTime(longValue);
                    }
                };

                ZZListDialog dialog = new ZZListDialog(SettingsActivity.this, "选择睡觉时间", itemList, valueList, listener);
                dialog.show();
            }
        });

        frequency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final List<String> itemList = new ArrayList<String>();
                List<String> valueList = new ArrayList<String>();
                itemList.add("不休息");
                itemList.add("15分钟");
                itemList.add("30分钟");
                itemList.add("45分钟");
                itemList.add("60分钟");
                valueList.add(String.valueOf(0L));
                valueList.add(String.valueOf(Constants.MIN_TIME * 15));
                valueList.add(String.valueOf(Constants.MIN_TIME * 30));
                valueList.add(String.valueOf(Constants.MIN_TIME * 45));
                valueList.add(String.valueOf(Constants.MIN_TIME * 60));
                ZZListDialog.DialogOnItemClickLister dialogOnItemClickLister = new ZZListDialog.DialogOnItemClickLister() {
                    @Override
                    public void onClick(int index, String value) {
                        Long longValue = Long.valueOf(value);
                        String valueText = ConvertLongTimeToString(longValue);
                        if (longValue > 0) {
                            frequencyText.setText(longValue / Constants.MIN_TIME + "分钟");
                        } else {
                            frequencyText.setText("");
                        }
                        TrackUtil.trackEvent(pv, "time.rest", itemList.get(index), 1);

                    }
                };
                ZZListDialog dialog = new ZZListDialog(SettingsActivity.this, "选择休息频率", itemList, valueList, dialogOnItemClickLister);
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
