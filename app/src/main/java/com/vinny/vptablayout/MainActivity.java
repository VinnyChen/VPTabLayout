package com.vinny.vptablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vinny.vptablayout.fragment.HomeFragment;
import com.vinny.vptablayout.fragment.HotFragment;
import com.vinny.vptablayout.fragment.MineFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Bind(R.id.home_fragment_container)
    LinearLayout homeContainer;

    @Bind(R.id.tab_home)
    LinearLayout homeTab;
    @Bind(R.id.img_tab_home)
    ImageView imgHomeTab;
    @Bind(R.id.tv_tab_home)
    TextView tvHomeTab;

    @Bind(R.id.tab_hot)
    LinearLayout hotTab;
    @Bind(R.id.img_tab_hot)
    ImageView imgHotTab;
    @Bind(R.id.tv_tab_hot)
    TextView tvHotTab;

    @Bind(R.id.tab_mine)
    LinearLayout mineTab;
    @Bind(R.id.img_tab_mine)
    ImageView imgMineTab;
    @Bind(R.id.tv_tab_mine)
    TextView tvMineTab;

    private Fragment homeFragment;
    private Fragment hotFragment;
    private Fragment mineFragment;

    private FragmentManager fManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initListener();
        //防止某种特殊情况出现的点击tab切换fragment不起作用
        if (savedInstanceState != null) {
            homeFragment = fManager.findFragmentByTag("homeFragment");
            hotFragment = fManager.findFragmentByTag("investFragment");
            mineFragment = fManager.findFragmentByTag("evaluationFragment");
        } else {
            showFragment(0);
        }
    }

    private void initListener() {
        homeTab.setOnClickListener(this);
        hotTab.setOnClickListener(this);
        mineTab.setOnClickListener(this);
    }

    private void initView() {
        imgHomeTab.setEnabled(false);
        tvHomeTab.setTextColor(getResources().getColor(R.color.theme_color));

        fManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View v) {
        changeTabIconState();
        changeTabTextState();
        switch (v.getId()){
            case R.id.tab_home://主页
                imgHomeTab.setEnabled(false);
                imgHotTab.setEnabled(true);
                imgMineTab.setEnabled(true);
                tvHomeTab.setTextColor(getResources().getColor(R.color.theme_color));
                showFragment(0);
                break;
            case R.id.tab_hot://热门
                imgHotTab.setEnabled(false);
                imgHomeTab.setEnabled(true);
                imgMineTab.setEnabled(true);
                tvHotTab.setTextColor(getResources().getColor(R.color.theme_color));
                showFragment(1);
                break;
            case R.id.tab_mine://我的
                imgMineTab.setEnabled(false);
                imgHomeTab.setEnabled(true);
                imgHotTab.setEnabled(true);
                tvMineTab.setTextColor(getResources().getColor(R.color.theme_color));
                showFragment(2);
                break;
        }
    }

    /**
     * 切换tab图标
     */
    private void changeTabIconState(){
        imgMineTab.setEnabled(false);
        imgHomeTab.setEnabled(true);
        imgHotTab.setEnabled(true);
    }

    /**
     * 修改tab文本颜色
     */
    private void changeTabTextState(){
        tvHomeTab.setTextColor(getResources().getColor(R.color.gray));
        tvHotTab.setTextColor(getResources().getColor(R.color.gray));
        tvMineTab.setTextColor(getResources().getColor(R.color.gray));
    }

    private void showFragment(int index){
        FragmentTransaction ft = fManager.beginTransaction();
        // 想要显示一个fragment,先隐藏所有fragment，防止重叠
        hideFragments(ft);
        switch (index){
            case 0:
                if(null != homeFragment) {
                    ft.show(homeFragment);
                }else{
                    homeFragment = new HomeFragment();
                    ft.add(R.id.home_fragment_container,homeFragment,"homeFragment").addToBackStack(null);
                }
                break;
            case 1:
                if(null != hotFragment) {
                    ft.show(hotFragment);
                }else{
                    hotFragment = new HotFragment();
                    ft.add(R.id.home_fragment_container,hotFragment,"hotFragment").addToBackStack(null);
                }
                break;
            case 2:
                if(null != mineFragment) {
                    ft.show(mineFragment);
                }else{
                    mineFragment = new MineFragment();
                    ft.add(R.id.home_fragment_container,mineFragment,"mineFragment").addToBackStack(null);
                }
                break;
            default:
                break;
        }
        ft.commitAllowingStateLoss();
    }

    /**
     * 当fragment已经实例化，就先隐藏起来
     * @param ft
     */
    private void hideFragments(FragmentTransaction ft){
        if(null != homeFragment)
            ft.hide(homeFragment);
        if(null != hotFragment)
            ft.hide(hotFragment);
        if(null != mineFragment)
            ft.hide(mineFragment);
    }
}
