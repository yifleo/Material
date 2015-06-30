package com.github.bean;

/**
 * Created by Administrator on 2015/6/10.
 */
public class SlideItem {
    private int drawableRes;
    private String title;

    public SlideItem(String title, int drawableRes) {
        this.title = title;
        this.drawableRes = drawableRes;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
