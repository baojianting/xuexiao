package com.dabao.xuexiao.common.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Scroller;

import com.dabao.xuexiao.common.Logger;

/**
 * Created by baojianting on 2015/5/21.
 */
public class DrawableSelectImageView extends ImageView {


    private static final String TAG = "DrawableSelectImageView";
    private static final int MODE_NONE = 0;
    private static final int MODE_DRAG = 1;
    private static final int MODE_ZOOM = 2;

    private Scroller mScroller;
    private Context mContext;

    private int mMode;
    private float mCurrentLen;
    private float mTempLen;

    private int mCurrentX;
    private int mCurrentY;
    private boolean mIsDrag;

    public DrawableSelectImageView(Context context) {
        super(context);
    }

    public void init(Context context) {
        mContext = context;
        mScroller = new Scroller(mContext);
        mMode = MODE_NONE;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.getInstance().error(TAG, "onTouchEvent" + event.getAction());

        int viewLeft = this.getLeft();
        int viewRight = this.getRight();
        int viewTop = this.getTop();
        int viewBottom = this.getBottom();
        int pointX = (int)event.getRawX();
        int pointY = (int)event.getRawY();

        if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
//            Logger.getInstance().error(TAG, "ACTION_DOWN click point is (" + pointX + "," + pointY + "); rect is (" + viewLeft + ","
//                + viewTop + "," + viewRight + ";" + viewBottom + ")");
            mMode = MODE_DRAG;
            mIsDrag = true;
            mCurrentX = pointX;
            mCurrentY = pointY;
            /*if (pointX >= viewLeft && pointX <= viewRight && pointY >= viewTop && pointY <= viewBottom) {
                Logger.getInstance().error(TAG, "ACTION_DOWN true");
                mIsDrag = true;
                mCurrentX = pointX;
                mCurrentY = pointY;
            } else {
                mIsDrag = false;
            }*/
        } else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_MOVE) {

            if (mIsDrag && mMode == MODE_DRAG) {
                int deltaX = pointX - mCurrentX;
                int deltaY = pointY - mCurrentY;
                mCurrentX = pointX;
                mCurrentY = pointY;
                this.setFrame(viewLeft + deltaX, viewTop + deltaY, viewLeft + this.getWidth() + deltaX, viewTop + this.getWidth() + deltaY);
//                Logger.getInstance().error(TAG, "ACTION_MOVE: " + (viewLeft + deltaX) + ";" + (viewTop + deltaY) + ";" +
//                        (viewLeft + this.getWidth() + deltaX) + ";" + (viewTop + this.getWidth() + deltaY));
                // scrollBy(deltaX, deltaY);
                // postInvalidate();
            } else if (mMode == MODE_ZOOM) {
                float len = getPointsLength(event);
                if (Math.abs(len - mTempLen) > 10f) {
                    float scale = (float) len / mCurrentLen;
                    Logger.getInstance().error(TAG, "ACTION_MOVE_ZOOM" + scale);
                    this.setScaleX(scale);
                    this.setScaleY(scale);
                }
                mTempLen = len;
            }
        } else if((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
            mIsDrag = false;
            mMode = MODE_NONE;
        } else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_DOWN) {
            mMode = MODE_ZOOM;
            mCurrentLen = getPointsLength(event);
            mTempLen = mCurrentLen;
            Logger.getInstance().error(TAG, "ACTION_POINTER_DOWN" + mCurrentLen);
        } else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_UP) {
            mMode = MODE_NONE;
        }
        return true;
    }

    public DrawableSelectImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableSelectImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float getPointsLength(MotionEvent event) {
        if (event.getPointerCount() == 2) {
            float deltaX = (event.getX(1) - event.getX(0)) * (event.getX(1) - event.getX(0));
            float deltaY = (event.getY(1) - event.getY(0)) * (event.getY(1) - event.getY(0));
            return (float)Math.sqrt(deltaX + deltaY);
        } else {
            return -1;
        }
    }
}
