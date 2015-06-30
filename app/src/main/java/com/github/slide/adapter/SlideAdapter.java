package com.github.slide.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.bean.SlideItem;
import com.github.material.R;
import com.github.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/9.
 */
public class SlideAdapter extends BaseAdapter {

    private Context context;
    private List<SlideItem> list;
    private ViewHolder holder;
    private String[] slideNames= Constants.SLIDE_NAME;
    private int[] slideImages= Constants.SLIDE_IMAGES;
    public SlideAdapter(Context context) {
        this.context = context;
        list = new ArrayList<SlideItem>();
        for (int i = 0; i <slideNames.length;i++) {
            list.add(new SlideItem(slideNames[i],slideImages[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_slide, viewGroup, false);
            holder = new ViewHolder();
            holder.iv_slide_icon = (ImageView) convertView.findViewById(R.id.iv_slide_icon);
            holder.tv_slide_content = (TextView) convertView.findViewById(R.id.tv_slide_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.e("测试", list.get(position).getTitle() + "----------");
        holder.iv_slide_icon.setImageDrawable(context.getResources().getDrawable(list.get(position).getDrawableRes()));
        holder.tv_slide_content.setText(list.get(position).getTitle());
        return convertView;
    }

    public class ViewHolder {
        private TextView tv_slide_content;
        private ImageView iv_slide_icon;
    }
}
