package com.example.monkey.mobiletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity {

    private Animation alphaAnimation;
    private Animation scaleAnimation;
    private Animation rotateAnimation;
    private Animation transAnimation;
    private Animation setAnimation;


    @BindView(R.id.anim_tv)
    TextView tv;

    @OnClick(R.id.animation_bt1)
    public void alpha(){
        tv.startAnimation(alphaAnimation);
    }

    @OnClick(R.id.animation_bt2)
    public void scale(){
        tv.startAnimation(scaleAnimation);
    }

    @OnClick(R.id.animation_bt3)
    public void rotate(){
        tv.startAnimation(rotateAnimation);
    }

    @OnClick(R.id.animation_bt4)
    public void trans(){
        tv.startAnimation(transAnimation);
    }

    @OnClick(R.id.animation_bt5)
    public void set(){
        tv.startAnimation(setAnimation);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initialAnimation();
        //tv.setOnClickListener();
    }

    private void initialAnimation() {
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        transAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
    }
}
