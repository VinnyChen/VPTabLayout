package com.vinny.vptablayout.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinny.vptablayout.R;

/**
 * @Description:
 * @author: chenguoguo
 * @date: 2017/8/3 下午4:45
 */
public class MineFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_mine,container,false);
        return view;
    }

}
