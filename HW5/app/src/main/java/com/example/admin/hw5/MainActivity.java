package com.example.admin.hw5;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    Animation[] animationList;                  //存放動畫清單
    private GridView mGridView;
    private ImageSwitcher mImgSwitcher;
    private Integer[] miImgArr = {
            R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08, R.drawable.img09,
            R.drawable.img10, R.drawable.img11, R.drawable.img12};
    private Integer[] miThumbImgArr = {
            R.drawable.img01th, R.drawable.img02th, R.drawable.img03th,
            R.drawable.img04th, R.drawable.img05th, R.drawable.img06th,
            R.drawable.img07th, R.drawable.img08th, R.drawable.img09th,
            R.drawable.img10th, R.drawable.img11th, R.drawable.img12th};
    private AdapterView.OnItemClickListener gridViewOnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            switch ((int) Math.floor(Math.random() * 4)) {
                case 0:
                    mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha_in));
                    mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha_out));
                    break;
                case 1:
                    mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.trans_in));
                    mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.trans_out));
                    break;
                case 2:
                    mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_rotate_in));
                    mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_rotate_out));
                    break;
                case 3:
                    mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_rotate_in));
                    mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_rotate_out));
                    break;
            }

            mImgSwitcher.setImageResource(miImgArr[position]);
        }
    };
    private AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int select = (int) Math.floor(Math.random() * 4);
            //Log.v("waaa", String.valueOf(select));
            mImgSwitcher.setInAnimation(animationList[select * 2]);
            mImgSwitcher.setOutAnimation(animationList[select * 2 + 1]);
            //Toast.makeText(MainActivity.this, String.valueOf(select), Toast.LENGTH_SHORT).show();
            mImgSwitcher.setImageResource(miImgArr[position]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);

        mImgSwitcher.setFactory(this);          // 主程式類別必須implements ViewSwitcher.ViewFactory
        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        ImageAdapter imgAdap = new ImageAdapter(this, miThumbImgArr);

        initAnimation();

        mGridView = (GridView) findViewById(R.id.gridView);
        mGridView.setAdapter(imgAdap);

        mImgSwitcher.setImageResource(R.drawable.img10);

        //mGridView.setOnItemClickListener(gridViewOnItemClick);
        mGridView.setOnItemClickListener(onItemClick);
    }

    protected void initAnimation() {
        ScaleAnimation scale;
        TranslateAnimation trans;
        RotateAnimation rotate;

        //=================alpha_in===========================
        AlphaAnimation alpha_in = new AlphaAnimation(0f, 1f);
        alpha_in.setInterpolator(new LinearInterpolator());
        alpha_in.setStartOffset(3000);
        alpha_in.setDuration(3000);

        //=================alpha_out===========================
        AlphaAnimation alpha_out = new AlphaAnimation(1f, 0f);
        alpha_out.setInterpolator(new LinearInterpolator());
        alpha_out.setStartOffset(0);
        alpha_out.setDuration(3000);

        //======================scale_rotate_in==============================
        AnimationSet scale_rotate_in = new AnimationSet(false);

        scale = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setInterpolator(new LinearInterpolator());
        scale.setStartOffset(3000);
        scale.setDuration(3000);

        rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setStartOffset(3000);
        rotate.setDuration(3000);

        scale_rotate_in.addAnimation(scale);
        scale_rotate_in.addAnimation(rotate);

        //======================scale_rotate_out==============================
        AnimationSet scale_rotate_out = new AnimationSet(false);

        scale = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setInterpolator(new LinearInterpolator());
        scale.setDuration(3000);

        rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setDuration(3000);

        scale_rotate_out.addAnimation(scale);
        scale_rotate_out.addAnimation(rotate);

        //======================scale_rotate_trans_in==============================
        AnimationSet scale_rotate_trans_in = new AnimationSet(false);

        scale = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setInterpolator(new LinearInterpolator());
        scale.setStartOffset(2000);
        scale.setDuration(3000);

        rotate = new RotateAnimation(0, 1080, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setStartOffset(2000);
        rotate.setDuration(3000);

        trans = new TranslateAnimation(0, 0, -500, 0);
        trans.setInterpolator(new LinearInterpolator());
        trans.setStartOffset(2000);
        trans.setDuration(3000);

        scale_rotate_trans_in.addAnimation(scale);
        scale_rotate_trans_in.addAnimation(rotate);
        scale_rotate_trans_in.addAnimation(trans);

        //======================scale_rotate_trans_out==============================
        AnimationSet scale_rotate_trans_out = new AnimationSet(false);

        scale = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setInterpolator(new LinearInterpolator());
        scale.setDuration(3000);

        rotate = new RotateAnimation(0, 1080, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setDuration(3000);

        trans = new TranslateAnimation(0, 0, 0, 500);
        trans.setInterpolator(new LinearInterpolator());
        trans.setDuration(3000);

        scale_rotate_trans_out.addAnimation(scale);
        scale_rotate_trans_out.addAnimation(rotate);
        scale_rotate_trans_out.addAnimation(trans);

        //======================trans_in==============================
        AnimationSet trans_in = new AnimationSet(false);

        trans = new TranslateAnimation(0, 0, -1000, 0);
        trans.setInterpolator(new LinearInterpolator());
        trans.setDuration(3000);

        trans_in.addAnimation(trans);
        //======================trans_out==============================
        AnimationSet trans_out = new AnimationSet(false);

        trans = new TranslateAnimation(0, 0, 0, 1000);
        trans.setInterpolator(new LinearInterpolator());
        trans.setDuration(3000);

        trans_out.addAnimation(trans);

        animationList = new Animation[]{
                alpha_in,
                alpha_out,
                scale_rotate_in,
                scale_rotate_out,
                scale_rotate_trans_in,
                scale_rotate_trans_out,
                trans_in,
                trans_out
        };
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        v.setBackgroundColor(Color.WHITE);
        return v;
    }
}

