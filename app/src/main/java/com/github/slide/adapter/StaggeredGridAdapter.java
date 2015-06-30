package com.github.slide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.material.R;
import com.github.utils.Constants;
import com.github.utils.DisplayUtils;
import com.github.utils.PlaceHolderDrawableHelper;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2015/6/19.
 */
public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.ViewHolder> {
    private ImageView iv_staggered_card;
    private Context context;
    private String[] imageUrls = Constants.IMAGES;


    public StaggeredGridAdapter(Context mContext) {
        this.context = mContext;

        Picasso p = new Picasso.Builder(mContext)
                .memoryCache(new LruCache(24000))
                .build();
        p.setIndicatorsEnabled(true);
        p.setLoggingEnabled(true);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_grid, parent, false);
        iv_staggered_card = (ImageView) view.findViewById(R.id.iv_staggered_card);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int height = (int) (Math.random() * DisplayUtils.dp2px(context,200)) + DisplayUtils.dp2px(context, 150);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height);
        holder.mImageView.setLayoutParams(params);

        Picasso.with(context).load(Constants.IMAGES[position]).placeholder(PlaceHolderDrawableHelper.getBackgroundDrawable(position)).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return imageUrls.length;
    }

   /* public void addDrawable(String imageUrl, int width, int height) {
        Log.d("POH", imageUrl);
        imageUrls.add(imageUrl);
        float ratio = (float) height / (float) width;
        ratios.add(ratio);
    }*/

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        protected TextView mTextView;
        protected ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            this.mImageView = (ImageView) v.findViewById(R.id.iv_staggered_card);

        }
    }

}
