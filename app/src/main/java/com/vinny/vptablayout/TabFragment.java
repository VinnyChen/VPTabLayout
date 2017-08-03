package com.vinny.vptablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @Description:
 * @author: chenguoguo
 * @date: 2017/8/3 上午9:57
 */
public class TabFragment extends Fragment {

    private TextView tvTab;
    private String tab;

    public static Fragment getInstance(String tab){
        TabFragment fragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tab",tab);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab,container,false);
        init(view);
        return view;
    }

    private void init(View view) {
        tvTab = (TextView) view.findViewById(R.id.tv_tab);
        tab = getArguments().getString("tab");
        tvTab.setText(tab);
    }


}
