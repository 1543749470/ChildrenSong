package com.example.childrensong;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.childrensong.base.SimpleActivity;
import com.example.childrensong.fragments.CacheFragment;
import com.example.childrensong.fragments.HearFragment;
import com.example.childrensong.fragments.LookFragment;

import butterknife.BindView;

public class MainActivity extends SimpleActivity {


    @BindView(R.id.status_bar_view)
    View statusBarView;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.myFrameLayout)
    FrameLayout myFrameLayout;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottomNavigationView;
    private LookFragment lookFragment;
    private HearFragment hearFragment;
    private CacheFragment cacheFragment;
    private FragmentManager supportFragmentManager;


    @Override
    protected void initView() {
        initFragment();
    }

    private void initFragment() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        bottomNavigationView.setSelectedItemId(R.id.tab_look);
        lookFragment = new LookFragment();
        hearFragment = new HearFragment();
        cacheFragment = new CacheFragment();

        supportFragmentManager = getSupportFragmentManager();
        final FragmentTransaction tr = supportFragmentManager.beginTransaction();

        tr.add(R.id.myFrameLayout,lookFragment);
        tr.add(R.id.myFrameLayout,hearFragment);
        tr.add(R.id.myFrameLayout,cacheFragment);
        toolbar.setNavigationIcon(R.drawable.icon_app_promotion);
        tr.show(lookFragment);
        tr.hide(hearFragment);
        tr.hide(cacheFragment);
        tr.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction tr1 = supportFragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.tab_look:
                        toolbarTitle.setText("宝宝看");
                        toolbar.setNavigationIcon(R.drawable.icon_app_promotion);
                        tr1.show(lookFragment);
                        tr1.hide(hearFragment);
                        tr1.hide(cacheFragment);
                        break;
                    case R.id.tab_hear:
                        toolbarTitle.setText("宝宝听");
                        toolbar.setNavigationIcon(R.drawable.icon_app_promotion);
                        tr1.show(hearFragment);
                        tr1.hide(lookFragment);
                        tr1.hide(cacheFragment);
                        break;
                    case R.id.tab_cache:
                        toolbarTitle.setText("缓存");
                        toolbar.setNavigationIcon(R.drawable.setting_unpressed);
                        tr1.show(cacheFragment);
                        tr1.hide(hearFragment);
                        tr1.hide(lookFragment);
                        break;
                }
                tr1.commit();
                return true;
            }
        });
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_main;
    }
}
