package com.github.slide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.material.R;
import com.github.utils.Constants;
import com.github.utils.ImageUtils;

/**
 * Created by Administrator on 2015/6/18.
 */
public class MainFragmentAdapter extends RecyclerView.Adapter<MainFragmentAdapter.ViewHolder> {
    private Context context;
    private String[] imageUrl = Constants.IMAGES;

    public MainFragmentAdapter(Context context) {
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        protected  TextView mTextView;
        protected  ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            this.mTextView = (TextView) v.findViewById(R.id.tv_main_content);
            this.mImageView = (ImageView) v.findViewById(R.id.iv_main_card);
        }
    }

    @Override
    public MainFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recycler_main, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ImageUtils.displayImage(Constants.IMAGES[position], holder.mImageView, context);

    }

    @Override
    public int getItemCount() {
        return imageUrl.length;
    }
}
