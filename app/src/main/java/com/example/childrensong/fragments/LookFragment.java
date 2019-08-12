package com.example.childrensong.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.childrensong.Beans.TabHandpickBeans;
import com.example.childrensong.R;
import com.example.childrensong.adapters.MyVpAdapter;
import com.example.childrensong.base.BaseFragment;
import com.example.childrensong.base.BasePresenter;
import com.example.childrensong.presenter.LookTabPresenterImp;
import com.example.childrensong.utils.LookTabInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//宝宝看界面
public class LookFragment extends BaseFragment<LookTabInterface.LookTabView, BasePresenter<LookTabInterface.LookTabView>> implements LookTabInterface.LookTabView {

    Unbinder unbinder;
    private static final String TAG = "LookFragment";
    @BindView(R.id.lookTab)
    TabLayout lookTab;
    @BindView(R.id.lookVP)
    ViewPager lookVP;
    Unbinder unbinder1;
    private LookTabPresenterImp<LookTabInterface.LookTabView> lookTabViewLookTabPresenterImp;
    ArrayList<TabHandpickBeans.DataBean> dataBeans = new ArrayList<>();
    int id;
    private ArrayList<Fragment> list;
    private MyVpAdapter myVpAdapter;

    @Override
    protected void initView() {
        lookTabViewLookTabPresenterImp.getHttp(id);


    }

    @Override
    protected int createLayout() {
        return R.layout.look_fragment_layout;
    }


    @Override
    protected BasePresenter<LookTabInterface.LookTabView> createPresenter() {
        lookTabViewLookTabPresenterImp = new LookTabPresenterImp<>();
        return lookTabViewLookTabPresenterImp;
    }

    @Override
    public void getlooktabSuccess(List<TabHandpickBeans.DataBean> albumsBeans) {
        Log.e(TAG, "getlooktabSuccess: " + albumsBeans);
        dataBeans.addAll(albumsBeans);

        list = new ArrayList<>();
        list.add(new JingXuanFragment());
        for (int i = 0; i < dataBeans.size(); i++) {
            HandPickFragment handPickFragment = new HandPickFragment();

            list.add(handPickFragment);
            Bundle bundle = new Bundle();
            bundle.putInt("id",albumsBeans.get(i).getId());
            handPickFragment.setArguments(bundle);

        }
        list.add(new PartnerFragment());
        myVpAdapter = new MyVpAdapter(getChildFragmentManager(), list);
        lookVP.setAdapter(myVpAdapter);
        lookTab.setupWithViewPager(lookVP);
        lookTab.getTabAt(0).setText("精选");
        for (int i = 1; i < dataBeans.size(); i++) {
            lookTab.getTabAt(i).setText(dataBeans.get(i-1).getName());

        }
        lookTab.getTabAt(dataBeans.size()).setText("英文");
        lookTab.getTabAt(dataBeans.size()+1).setText("伙伴");


    }

    @Override
    public void getlooktabFiladle(String error) {
        Log.e(TAG, "getlooktabFiladle: " + error);
    }





}


