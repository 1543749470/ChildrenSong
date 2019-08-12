package com.example.childrensong.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class HearVpAdaper extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> tablist;


    public HearVpAdaper(FragmentManager fm,ArrayList<Fragment> list,ArrayList<String> tablist) {
        super(fm);
        this.list=list;
        this.tablist = tablist;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position);
    }
}
