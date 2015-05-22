package com.dabao.xuexiao.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.dabao.xuexiao.R;
import com.dabao.xuexiao.common.Logger;


/**
 * Created by baojianting on 2015/5/20.
 */
public class ClearableEditText extends EditText {

    public static final String TAG = "ClearableTextView";
    private Context mContext;
    private Drawable mRightDrawable;
    private boolean isShown;
    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            shouldShowClearBtn();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public ClearableEditText(Context context) {
        super(context);
        init(context);
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ClearableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        mContext = context;
        mRightDrawable = context.getResources().getDrawable(R.drawable.clearable_text_view_clear);
        mRightDrawable.setBounds(0, 0, mRightDrawable.getMinimumWidth(), mRightDrawable.getMinimumHeight());
        Logger.getInstance().error(TAG, "the drawable minimumwidth is " + mRightDrawable.getMinimumWidth() +
                "; minmumHeight is " + mRightDrawable.getMinimumHeight());
        this.addTextChangedListener(mTextWatcher);
    }


    public void shouldShowClearBtn() {
        CharSequence current_str = this.getText();
        if (null == current_str || current_str.equals("")) {
            this.setCompoundDrawables(null, null, mRightDrawable, null);
            isShown = false;
        } else {
            this.setCompoundDrawables(null, null, null, null);
            isShown = true;
        }
    }

    /*public void setClearText(String text) {
        super.setText(text);
        shouldShowClearBtn();
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP && isShown) {
            int currentX = (int) event.getX();
            int currentY = (int) event.getY();

            Rect bounds = mRightDrawable.getBounds();
            if (currentX >= (this.getWidth() - bounds.width()) && currentX <= (this.getWidth() - this.getPaddingRight())
                    && currentY >= this.getPaddingTop() && currentY <= (this.getHeight() - this.getPaddingBottom())) {
                event.setAction(MotionEvent.ACTION_CANCEL);
                this.setText("");
            }
        }
        return super.onTouchEvent(event);
    }


}
