package com.example.monkey.mobiletest;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.monkey.mobiletest.bean.Book;
import com.example.monkey.mobiletest.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener{

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt4;
    private ImageButton bt5;
    private GestureDetector mGestureDector;

    @BindView(R.id.fl)
    FrameLayout fl;

    @OnClick(R.id.animation_bt)
    public void toActivityA(){
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.animator_bt)
    public void toAnimator(){
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);
    }

    @OnClick(R.id.timer_bt)
    public void btTimerClick(){
        toActivity(timerActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    private void initialView(){
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt4 = (ImageButton) findViewById(R.id.bt4);
        bt5 = (ImageButton) findViewById(R.id.bt5);
    }

    private void initialListener(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Monkey");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivityForResult(intent, 3);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(CombinedActivity.class);
//                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
//                startActivity(intent);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(A.class);
//                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            default:
        }
    }

    public void onClick(View v){
        //Toast.makeText(this, "Button2 was clicked", Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        UtilLog.logD("testD", "Toast");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDector.onTouchEvent(event);
    }

    public class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e){
            UtilLog.logD("MyGesture", "onDown");
            toastShort("onDown");
            return true;
        }

        public void onShowPress(MotionEvent e){
            UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e){
            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e){
            toastShort("onSingleTapUp");
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            UtilLog.logD("MyGesture", "onScroll" + (e2.getX()-e1.getX()) + "   " + distanceX);
            toastShort("onScroll");
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            toastShort("onFLing");
            return true;
        }

        public boolean onDoubleTap(MotionEvent e){
            toastShort("onDoubleTap");
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e){
            toastShort("onDoubleTapEvent");
            return true;
        }
    }
}
