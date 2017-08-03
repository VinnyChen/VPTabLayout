package com.vinny.vptablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TabFragmentPageAdapter pageAdapter;
    private List<Fragment> fragments;
    private List<String> mContents;
    private List<String> mTitles;
//    private String[] mContents = new String[]{"page1", "page2", "page3","page4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.taglayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        fragments = new ArrayList<>();
        mContents = new ArrayList<>();
        mTitles = new ArrayList<>();
        for(int i=0;i<10;i++){
            mContents.add("fragment"+(i+1));
            mTitles.add("tab"+(i+1));
            fragments.add(TabFragment.getInstance(mContents.get(i)));
        }
        pageAdapter = new TabFragmentPageAdapter(getSupportFragmentManager(),fragments,mTitles);
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
