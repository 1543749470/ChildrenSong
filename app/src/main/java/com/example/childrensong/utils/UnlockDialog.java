package com.example.childrensong.utils;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.childrensong.R;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class UnlockDialog extends Dialog {

    @BindView(R.id.tip_text)
    TextView tipText;
    @BindView(R.id.close)
    ImageView close;
    private View.OnClickListener mOkListener = null;
    private OnDismissListener mOnDismissListener;

    private String pv = "setting.lock";

    @BindView(R.id.tip_container)
    View tip;
    @BindViews({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9,})
    TextView[] btns;
    @BindViews({R.id.btn_bg_0, R.id.btn_bg_1, R.id.btn_bg_2, R.id.btn_bg_3, R.id.btn_bg_4, R.id.btn_bg_5, R.id.btn_bg_6, R.id.btn_bg_7, R.id.btn_bg_8, R.id.btn_bg_9,})
    RelativeLayout[] btn_bgs;
    @BindView(R.id.unlock_question)
    TextView question;

    @BindView(R.id.unlock_input)
    TextView input;


    @BindView(R.id.root)
    View root;

    @BindView(R.id.title)
    TextView title;

    private int first = -1;
    private int second = -1;
    private Context context;
    private Unbinder bind;

    public UnlockDialog(Context context, String titleString, String tipString, View.OnClickListener okListener) {
        super(context, R.style.pwAnimation);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(true);
        this.setContentView(R.layout.pop_math);
        mOkListener = okListener;
        TrackUtil.trackEvent(pv, "view");
        bind = ButterKnife.bind(this);
        this.context = context;

        if (TextUtils.isEmpty(tipString)) {
            tip.setVisibility(View.GONE);
        } else {
            tipText.setText(tipString);
        }
        title.setText(titleString);
        createQuestion();
        bindEvent();
    }

    public UnlockDialog(Context context, String titleString, String tipString, View.OnClickListener okListener, OnDismissListener onDismissListener) {
        super(context, R.style.pwAnimation);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(true);
        this.setContentView(R.layout.pop_math);
        mOkListener = okListener;
        mOnDismissListener = onDismissListener;
        TrackUtil.trackEvent(pv, "view");
        ButterKnife.bind(this);

        if (TextUtils.isEmpty(tipString)) {
            tip.setVisibility(View.GONE);
        } else {
            tipText.setText(tipString);
        }
        title.setText(titleString);
        createQuestion();
        bindEvent();
    }

    private void createQuestion() {
        int left = 0;
        int right = 0;

        while (left * right < 10) {
            left = (int) (Math.random() * 10);
            right = (int) (Math.random() * 10);
        }

        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }

        int result = left * right;
        first = result / 10;
        second = result % 10;
        question.setText(left + " x " + right + " = ");
    }
    private void bindEvent() {
        for (RelativeLayout view : btn_bgs) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                   disableFor1Second(v);
                    TextView tv = (TextView) ((RelativeLayout) v).getChildAt(0);
                    int number = Integer.parseInt(tv.getText().toString());

                    if (TextUtils.isEmpty(input.getText())) {
                        if (number == first) {
                            input.setText(String.valueOf(number));
                        } else {
                            TrackUtil.trackEvent(pv, "unlock.fail");
                            reset();
                        }
                    } else {
                        if (number == second) {
                            input.setText(input.getText() + String.valueOf(second));
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (mOkListener != null) {
                                        mOkListener.onClick(v);
                                        TrackUtil.trackEvent(pv, "unlock.success");
                                    }
                                    dismiss();
                                }
                            }, 100);
                        } else {
                            TrackUtil.trackEvent(pv, "unlock.fail");
                            reset();
                        }
                    }
                }
            });
        }


    }


    public static void disableFor1Second(final View v) {
        disable(v, 1000);
    }

    private static void disable(final View v, long duration) {
        if (v == null) {
            return;
        }

        try {
            v.setEnabled(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    v.setEnabled(true);
                }
            }, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        input.setText("");
        shake();
        first = -1;
        second = -1;
        createQuestion();
    }

    @Override
    public void show() {
        super.show();
    }


    @Override
    public void dismiss() {
        if (isShowing()) {
            super.dismiss();
            if (mOnDismissListener != null) {
                mOnDismissListener.onDismiss(this);
            }
        }
    }

    public void shake() {
        ObjectAnimator.ofFloat(root, "translationX", 0, 25, -25, 25, -25, 15, -15, 6, -6, 0).start();
    }

    @OnClick(R.id.root)
    public void rootClick() {
        dismiss();
    }

    @OnClick(R.id.container)
    public void containerClick() {

    }

    @OnClick(R.id.close)
    public void closeClick() {
        TrackUtil.trackEvent(pv, "close.click");
        dismiss();
    }


}
