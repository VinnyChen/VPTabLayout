package com.vinny.vptablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Description:
 * @author: chenguoguo
 * @date: 2017/8/3 上午10:00
 */
public class TabFragmentPageAdapter extends FragmentPagerAdapter {

    private List<String> mTitles;
    private List<Fragment> fragments;


    public TabFragmentPageAdapter(FragmentManager fm,List<Fragment> fragments,List<String> mTitles) {
        super(fm);
        this.fragments = fragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
