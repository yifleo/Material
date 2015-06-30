package com.github.slide.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.base.BaseFragment;
import com.github.material.R;

/**
 * Created by Administrator on 2015/6/23.
 */
public class ToolbarFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        //  getActivity().findViewById(R.id.toolbar).setAlpha(0.5f);

        return view;
    }
}
