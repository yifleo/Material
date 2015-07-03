package com.github.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2015/6/9.
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        // 初始化控件
        initView();
        // 初始化监听器
        initListener();
        // 处理数据
        initData(this);
    }
}
