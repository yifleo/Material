package com.github.base;

import android.content.Context;

/**
 * Activity接口
 *
 * @author
 * @version 1.0
 */
public interface IBaseActivity {


    public int getLayoutResId();

    /**
     * 初始化控件
     */
    public void initView();

    /**
     * 初始化监听器
     */
    public void initListener();

    /**
     * 业务处理操作（onCreate方法中调用）
     *
     * @param mContext 当前Activity对象
     */
    public void initData(Context mContext);

    /**
     * 暂停恢复刷新相关操作（onResume方法中调用）
     */
    public void resume();

    /**
     * 销毁、释放资源相关操作（onDestroy方法中调用）
     */
    public void destroy();

    public void pause();

}
