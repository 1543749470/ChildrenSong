package com.example.childrensong;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.childrensong.activity.SettingsActivity;
import com.example.childrensong.base.SimpleActivity;
import com.example.childrensong.fragments.CacheFragment;
import com.example.childrensong.fragments.HearFragment;
import com.example.childrensong.fragments.LookFragment;

import com.example.childrensong.utils.TrackUtil;
import com.example.childrensong.utils.UnlockDialog;

import butterknife.BindView;
import butterknife.BindViews;

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
    private PopupWindow popupWindow;
    private View mBtn2;


    @Override
    protected void initView() {
        initFragment();
    }

    private void initFragment() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbarTitle.setText("宝宝看");
        bottomNavigationView.setSelectedItemId(R.id.tab_look);
        lookFragment = new LookFragment();
        hearFragment = new HearFragment();
        cacheFragment = new CacheFragment();

        supportFragmentManager = getSupportFragmentManager();
        final FragmentTransaction tr = supportFragmentManager.beginTransaction();

        tr.add(R.id.myFrameLayout, lookFragment);
        tr.add(R.id.myFrameLayout, hearFragment);
        tr.add(R.id.myFrameLayout, cacheFragment);
        toolbar.setNavigationIcon(R.drawable.icon_app_promotion);
        tr.show(lookFragment);
        tr.hide(hearFragment);
        tr.hide(cacheFragment);
        tr.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction tr1 = supportFragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.tab_look:
                        toolbarTitle.setText("宝宝看");
                        toolbar.setNavigationIcon(R.drawable.icon_app_promotion);
                        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "红包", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tr1.show(lookFragment);
                        tr1.hide(hearFragment);
                        tr1.hide(cacheFragment);
                        break;
                    case R.id.tab_hear:
                        toolbarTitle.setText("宝宝听");
                        toolbar.setNavigationIcon(R.drawable.icon_app_promotion);
                        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "红包", Toast.LENGTH_SHORT).show();
                            }
                        });
                        tr1.show(hearFragment);
                        tr1.hide(lookFragment);
                        tr1.hide(cacheFragment);
                        break;
                    case R.id.tab_cache:
                        toolbarTitle.setText("缓存");
                        toolbar.setNavigationIcon(R.drawable.setting_unpressed);
                        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showAnimalDialog();
                                //  startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                            }
                        });
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



    private void showAnimalDialog() {
        UnlockDialog dialog = new UnlockDialog(this, "请确认您是家长", null, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,SettingsActivity.class));
            }
        });
        dialog.show();
    }
//popwindow 上下文动画
  /*  private void initpop() {
        View inflate = View.inflate(MainActivity.this, R.layout.pop_math, null);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //点击非菜单部分退出
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setAnimationStyle(R.style.pwAnimation);
        popupWindow.setFocusable(true);
    }
*/
    @Override
    protected int createLayout() {

        return R.layout.activity_main;
    }
}
