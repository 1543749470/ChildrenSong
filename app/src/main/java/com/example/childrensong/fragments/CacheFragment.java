package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.childrensong.R;
import com.example.childrensong.adapters.MyVpAdapter;
import com.example.childrensong.base.SimpleFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//缓存界面
public class CacheFragment extends SimpleFragment {
    @BindView(R.id.cacheTab)
    TabLayout cacheTab;
    @BindView(R.id.cacheVP)
    ViewPager cacheVP;
    Unbinder unbinder;

    @Override
    protected void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        VideoAlbumFragment videoAlbumFragment = new VideoAlbumFragment();
        VideoFragment videoFragment = new VideoFragment();
        FrequencyFragment frequencyFragment = new FrequencyFragment();
        fragments.add(videoAlbumFragment);
        fragments.add(videoFragment);
        fragments.add(frequencyFragment);


        MyVpAdapter myVpAdapter = new MyVpAdapter(getFragmentManager(), fragments);
        cacheVP.setAdapter(myVpAdapter);
        cacheTab.setupWithViewPager(cacheVP);
        cacheTab.getTabAt(0).setText("视频专辑");
        cacheTab.getTabAt(1).setText("视频");
        cacheTab.getTabAt(2).setText("音频");

    }

    @Override
    protected int createLayout() {
        return R.layout.cache_fragmennt_layout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.cache, menu);
    }


}
