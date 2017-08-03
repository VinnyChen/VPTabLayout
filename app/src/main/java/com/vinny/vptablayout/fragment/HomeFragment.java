package com.vinny.vptablayout.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinny.vptablayout.R;
import com.vinny.vptablayout.adapter.TabFragmentPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: chenguoguo
 * @date: 2017/8/3 下午4:45
 */
public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TabFragmentPageAdapter pageAdapter;
    private List<Fragment> fragments;
    private List<String> mContents;
    private List<String> mTitles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_home,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.taglayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        fragments = new ArrayList<>();
        mContents = new ArrayList<>();
        mTitles = new ArrayList<>();
        for(int i=0;i<10;i++){
            mContents.add("fragment"+(i+1));
            mTitles.add("tab"+(i+1));
            fragments.add(TabFragment.getInstance(mContents.get(i)));
        }
        pageAdapter = new TabFragmentPageAdapter(getActivity().getSupportFragmentManager(),fragments,mTitles);
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
