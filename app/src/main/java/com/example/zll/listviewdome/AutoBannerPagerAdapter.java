package com.example.zll.listviewdome;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.bumptech.glide.Glide;
/**
 * Created by zll on 2018/2/1.
 */

public class AutoBannerPagerAdapter extends PagerAdapter {
private Context mContext;
private List<String> mImgUrls;
private List<View> mImageViews;
private AutoBanner.AutoBannerListener mAutoBannerListener;


    public AutoBannerPagerAdapter(Context context,List<String> urls,AutoBanner.AutoBannerListener mAutoBannerListener){
        this.mContext=context;
        this.mImgUrls=urls;
        this.mAutoBannerListener=mAutoBannerListener;
        mImageViews=new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageViews.add(imageView);
        }
    }
@Override
    public int getCount() {
        return mImageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
       container.addView(mImageViews.get(position));
       ImageView view=(ImageView)mImageViews.get(position);
       Glide.with(mContext).load(mImgUrls.get(position)).into(view);
//判断
        if (mAutoBannerListener!=null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAutoBannerListener.onClickListener(position);
                }
            });


        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        super.destroyItem(container, position, object);
    }
}
