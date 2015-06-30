package com.github.material;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.github.base.BaseActivity;
import com.github.slide.adapter.SlideAdapter;
import com.github.slide.fragment.MainFragment;
import com.github.slide.fragment.StaggeredGridFragment;
import com.github.slide.fragment.ToolbarFragment;
import com.github.utils.DisplayUtils;
import com.github.utils.FragmentUtils;


public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    //-----------------------------------------drawer------------------------------------------//
    private DrawerLayout mDrawerLayout;
    private ListView lv_slide;
    private SlideAdapter slideAdapter;
    private LinearLayout linLay_slide_left;

    //-----------------------------------------toolbar------------------------------------------//
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;

    //-----------------------------------------other------------------------------------------//
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initSlide();
    }

    private void initListener() {
        lv_slide.setOnItemClickListener(this);
    }

    private void initView() {
        context = this;
        lv_slide = (ListView) findViewById(R.id.lv_slide);
        linLay_slide_left = (LinearLayout) findViewById(R.id.linLay_slide_left);
        slideAdapter = new SlideAdapter(context);
        lv_slide.setAdapter(slideAdapter);
        FragmentUtils.addFragment(getSupportFragmentManager(), new MainFragment(), R.id.fraLay_main);
    }

    private void initSlide() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);
        DrawerLayout.LayoutParams params = (android.support.v4.widget.DrawerLayout.LayoutParams) linLay_slide_left
                .getLayoutParams();
        params.width = (int) (DisplayUtils.getScreenWidth(context) * 0.7);
        linLay_slide_left.setLayoutParams(params);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void closeDrawer() {
        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0:
                FragmentUtils.replaceFragment(getSupportFragmentManager(), new MainFragment(), R.id.fraLay_main);
                closeDrawer();
                break;
            case 1:
                FragmentUtils.replaceFragment(getSupportFragmentManager(), new StaggeredGridFragment(), R.id.fraLay_main);
                closeDrawer();
                break;
            case 2:
                FragmentUtils.replaceFragment(getSupportFragmentManager(), new ToolbarFragment(), R.id.fraLay_main);
                closeDrawer();
                break;
            default:
                break;

        }

    }
}
