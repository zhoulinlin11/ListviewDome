package com.example.zll.listviewdome;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by zll on 2018/2/1.
 */

public class AutoBanner extends FrameLayout {

    private ArrayList<String> mImgUrls;
    private ArrayList<ImageView> mIndicatorViews;
    private ViewPager mviewpager;
    private LinearLayout mlinearLayout;
    private Context mContext;
    private float ratio=1.78f;
    private int count;
    //自动轮播
    private boolean isAuto=true;
    private Handler mAutoHandler=new Handler();
    private int currentItem;
    private int delayTime=1000;

    public AutoBanner(@NonNull Context context) {
        super(context);
        init(context);
    }

    public AutoBanner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AutoBanner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    //定义一个方法
    public void init(Context context){
        this.mContext=context;
        //定义一个存储图片的集合
        mImgUrls = new ArrayList<>();
        //图片位置的集合
        mIndicatorViews = new ArrayList<>();
        //找到布局文件
        View view=LayoutInflater.from(context).inflate(R.layout.denglu,this);
        //查找控件
        mviewpager = view.findViewById(R.id.banner_viewpager);
        mlinearLayout = view.findViewById(R.id.banner_linearLayout);
    }
    //实现一个接口

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    initViewPagerParams();
    }
    //计算viewpager的宽和高比，以便进行适配
    private  void initViewPagerParams(){
        //获取viewpager的布局
        ViewGroup.LayoutParams params = mviewpager.getLayoutParams();
        //宽度
      params.width=getMeasuredWidth();
      //高
        params.height=(int)(params.width/ratio);
        mviewpager.setLayoutParams(params);
    }
    //配置图片资源
    public AutoBanner load(List<String> imgs){
        this.mImgUrls= (ArrayList<String>) imgs;
        this.count=mImgUrls.size();
        return this;
    }
    //加载和显示banner
    public AutoBanner display(){

        return this;
    }
    private void setViewPager(){
        if (count==0){
            return;
        }

    }

    public class AutoBannerListener {
        public void onClickListener(int position) {
        }
    }
}
