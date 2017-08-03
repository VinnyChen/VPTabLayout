# VPTabLayout
ViewPager+TabLayout+Fragment实现左右页面滑动效果

# 实现步骤
## 1、添加依赖
compile 'com.android.support:appcompat-v7:25.3.1'<br/>
compile 'com.android.support:design:25.3.1'
## 2、布局结合使用
  
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.vinny.vptablayout.MainActivity">

    <android.support.design.widget.TabLayout
        android:id="@+id/taglayout"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:background="#ffff00"
        app:tabBackground="@drawable/selector_tab"
        app:tabIndicatorColor="@color/colorAccent"
        app:tabIndicatorHeight="2dp"
        app:tabMode="scrollable"
        app:tabSelectedTextColor="#CC33FF"
        app:tabTextAppearance="@style/MyTabLayoutTextAppearance"
        app:tabTextColor="@color/colorGray" />

    <android.support.v4.view.ViewPager
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>

        
## 3、创建对应的Fragment和Tab，并在FragmentPageAdapter中重写getPageTitle方法，根据position确认对应位置tab的文字显示
    private String[] mTitles = new String[]{"tab1", "tab2", "tab3","tab4"};
    private List<Fragment> fragments;
    private List<Stirng> mTitles;

    public TabFragmentPageAdapter(FragmentManager fm,List<Fragment> fragments,List<Stirng> mTitles) {
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
## 4、绑定ViewPager与TabLayout
  tabLayout.setupWithViewPager(viewPager);

# TabLayout常见属性
## app:tabBackground="color"
设置TabLayout背景颜色，此处使用selector，来区分选中与未选中的颜色

## app:tabIndicatorColor="@android:color/xxx"
设置指示器下标的颜色

## app:tabIndicatorHeight="xxdp"
设置指示器下标的高度

## app:tabTextAppearance="@android:style/xxx"
设置文字的大小、颜色等外貌（通过新建一个style来设置）

## app:tabSelectedTextColor="@android:color/xxx"
设置选中字体的颜色

## app:tabTextColor="@color/colorPrimary"
设置未选中字体的颜色

## app:tabMode="scrollable"
设置Tab的模式是否可滑动，默认模式为fix，此种模式如果tab过多，则会出现tab挤压在一起的情况，无法滑动,设置为scrollable则可以滑动

## app:tabMaxWidth="xxdp"
设置tab的最大宽度

## app:tabMinWidth="xxdp"
设置tab的最小宽度

# 如何添加tab
## 方式一：代码中设置
  tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));  
  tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));  
  ...
## 方式二：布局文件中设置
<android.support.design.widget.TabLayout
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">

    <android.support.design.widget.TabItem
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Tab1" />

    <android.support.design.widget.TabItem
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Tab2" />
    ...
</android.support.design.widget.TabLayout>
## 方式三：结合ViewPager后使用（见上面ViewPager+TabLayout结合处）

# 如何与ViewPager结合使用

在FragmentPageAdapter中重写getPageTitle方法，根据position确认对应位置tab的文字显示
    
    
   ## tabLayout.setupWithViewPager(viewPager);
   绑定ViewPager与TabLayout
   
   ## tablayout.getTabAt(position).select();
   默认选择position位置的项
