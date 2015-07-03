package com.github.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/6/9.
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {
    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        setContentView(getLayoutResId());
        // 初始化控件
        initView();
        // 初始化监听器
        initListener();
        // 处理数据
        initData(this);
        return super.onCreateView(parent, name, context, attrs);
    }
}
