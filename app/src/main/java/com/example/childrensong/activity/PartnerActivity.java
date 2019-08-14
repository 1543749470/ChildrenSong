package com.example.childrensong.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.childrensong.R;
import com.example.childrensong.adapters.PartnerAdapter;
import com.example.childrensong.base.SimpleActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PartnerActivity extends SimpleActivity {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.partner_title)
    TextView partnerTitle;
    @BindView(R.id.partner_recycler)
    RecyclerView partnerRecycler;

    @Override
    protected void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbarTitle.setText("内容合作");
        toolbar.setNavigationIcon(R.drawable.icon_common_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        partnerRecycler.setLayoutManager(new GridLayoutManager(this,4));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("http://stauxqb.ergedd.com/h5/img/01_xiaozhupeiqi.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/02_wangwangdui.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/03_chaojifeixia.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/04_mengjixiaodui.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/05_xiaomabaoli.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/06_haidixiaocongdui.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/07_baobaobashi.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/08_batamu.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/09_tuxiaobeierge.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/10_bianxingjingang.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/11_landierge.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/12_qianqianjianbihua.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/13_qiakedamaoxian.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/14_xionghaizi.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/15_fangkuaixiong.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/16_little-fox.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/17_halierge.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/08_batamu.png");
        strings.add("http://stauxqb.ergedd.com/h5/img/19_wangqubaobei.png");
        PartnerAdapter partnerAdapter = new PartnerAdapter(this);
        partnerRecycler.setAdapter(partnerAdapter);
        partnerAdapter.initData(strings);

    }

    @Override
    protected int createLayout() {
        return R.layout.activity_partner;
    }


}
