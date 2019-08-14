package com.example.childrensong.utils;

/**
 * Created by maochen on 16/8/7.
 */

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.childrensong.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by maochen on 14-8-4.
 */

public class ZZListDialog extends ProgressDialog {

    private int mTitleResId = -1;
    private String mTitleText = null;

    private DialogOnItemClickLister mClickListener;

    private ArrayList<String> mListItem = new ArrayList<String>();
    private ArrayList<String> mListValue = new ArrayList<String>();


    public ZZListDialog(Context context, String title, List<String> listItem, List<String> listValue, DialogOnItemClickLister listListener) {
        super(context, R.style.ZZDialogDimEnabled);

        mTitleText = title;

        if (listItem != null)
            mListItem.addAll(listItem);

        if (listValue != null)
            mListValue.addAll(listValue);

        if (listListener != null)
            mClickListener = listListener;
    }

    public ZZListDialog(Context context, int titleResId, List<String> listItem, List<String> listValue, DialogOnItemClickLister listListener) {
        super(context, R.style.ZZDialogDimEnabled);

        mTitleResId = titleResId;

        if (listItem != null)
            mListItem.addAll(listItem);

        if (listValue != null)
            mListValue.addAll(listValue);

        if (listListener != null)
            mClickListener = listListener;
    }
    public static void setBottomDialogTheme(AlertDialog dialog) {
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dialog_animation_bottom);

        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
    }
    @Override
    public void show() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.show();
        setBottomDialogTheme(this);

        this.setContentView(R.layout.dialog_list);
        this.setCanceledOnTouchOutside(true);

        TextView textViewTitle = (TextView) this.findViewById(R.id.dialog_title);

        if (mTitleText != null || mTitleResId > 0) {
            textViewTitle.setVisibility(View.VISIBLE);
        } else {
            textViewTitle.setVisibility(View.GONE);
        }

        if (mTitleText != null) {
            textViewTitle.setText(mTitleText);
        }

        if (mTitleResId > 0) {
            textViewTitle.setText(mTitleResId);
        }

        LinearLayout listFrame = (LinearLayout) this.findViewById(R.id.dialog_list_frame);

        if (mListItem.size() > 0 && mListValue.size() > 0 && mListItem.size() == mListValue.size()) {
            for (int i = 0; i < mListItem.size(); i++) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View itemframe = inflater.inflate(R.layout.dialog_list_item, listFrame, false);

                TextView tv = (TextView) itemframe.findViewById(R.id.dialog_list_item_text);
                tv.setText(mListItem.get(i));

                final int index = i;
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mClickListener != null) {
                            String value = mListValue.get(index);
                            mClickListener.onClick(index, value);
                        }

                        dismiss();
                    }
                });

                listFrame.addView(itemframe);
            }
        }

        setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
            }
        });
    }

    @Override
    public void dismiss() {
        if (isShowing())
            super.dismiss();
    }

    public interface DialogOnItemClickLister {
        public void onClick(int index, String value);
    }
}