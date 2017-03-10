package com.example.monkey.mobiletest;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClickDialog extends Dialog {

    private int checkedID;

    @BindView(R.id.click_rg)
    RadioGroup radioGroup;
    @OnClick(R.id.bt_okay)
    public void okayClick(){
        switch (checkedID){
            case R.id.click_rg_bt1:
                dismiss();
                listener.onToDialog();
                break;
            case R.id.click_rg_bt2:
                dismiss();
                listener.onToListView();
                break;
            default:
                dismiss();
                listener.onClickListener();
        }
    }

    @OnClick(R.id.bt_cancel)
    public void cancelClick(){
        switch (checkedID){
            case R.id.click_rg_bt1:
                dismiss();
                listener.onToCombined();
                break;
            case R.id.click_rg_bt2:
                dismiss();
                listener.onToCombined();
                break;
            default:
        }
    }

    private IClickDialogEventListenerClick listener;

    public interface IClickDialogEventListenerClick{
        public void onClickListener();
        public void onToListView();
        public void onToDialog();
        public void onToCombined();
    }


    public ClickDialog(@NonNull Context context, ClickDialog.IClickDialogEventListenerClick listener){
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                checkedID = checkedId;
            }
        });
    }
}
