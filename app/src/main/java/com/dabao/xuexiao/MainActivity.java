package com.dabao.xuexiao;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dabao.xuexiao.common.Logger;
import com.dabao.xuexiao.common.view.ClearableEditText;
import com.dabao.xuexiao.news.NewsFragment;
import com.dabao.xuexiao.publish.MyPublishFragment;
import com.dabao.xuexiao.setting.SettingFragment;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

    private Fragment mNewsFragment;
    private Fragment mMyPublishFragment;
    private Fragment mSettingFragment;

    private Context mContext;
    private TextView mNewsTextView;
    private TextView mMyPublishTextView;
    private TextView mSettingTextView;
    private TabType mCurrentFragmentType;


    private enum FragmentTransactionType {
        FRAGMENT_ADD,
        FRAGMENT_REPlACE,
        FRAGMENT_REMOVE
    }

    private enum TabType {
        NEWS,
        MYPUBLISH,
        SETTING
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      /*  ViewGroup mainView = (ViewGroup) LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.activity_main, null);
        ClearableEditText clearableEditText = new ClearableEditText(this.getApplicationContext());
        clearableEditText.setAlpha((float)0.5);
        clearableEditText.setBackground(this.getResources().getDrawable(R.drawable.activity_register_edittext_bg));
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mainView.addView(clearableEditText, lp);
        setContentView(mainView);
*/
        setContentView(R.layout.activity_main);
        init();
        fragmentTransaction(FragmentTransactionType.FRAGMENT_ADD, mNewsFragment, R.id.activity_main_content);
//        ImageView imageView = (ImageView)this.findViewById(R.id.activity_drawable_select_imageview);
//        View view = (View)this.findViewById(R.id.activity_drawable_select_view);
//        imageView.setImageResource(R.drawable.test1);

    }

    public void init() {
        mContext = this.getApplicationContext();
        mNewsTextView = (TextView)this.findViewById(R.id.activity_main_tab_bottom_new_textview);
        mNewsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.getInstance().error(TAG, "newsTextView click");
                selectFragment(TabType.NEWS);
            }
        });
        mMyPublishTextView = (TextView)this.findViewById(R.id.activity_main_tab_bottom_publish_textview);
        mMyPublishTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.getInstance().error(TAG, "mypublishTextView click");
                selectFragment(TabType.MYPUBLISH);
            }
        });
        mSettingTextView = (TextView)this.findViewById(R.id.activity_main_tab_bottom_setting_textview);
        mSettingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.getInstance().error(TAG, "settingTextView click");
                selectFragment(TabType.SETTING);
            }
        });
        mNewsFragment = new NewsFragment();
        mCurrentFragmentType = TabType.NEWS;
    }

    public void fragmentTransaction(FragmentTransactionType type, Fragment fragment, int containerViewId) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (type) {
            case FRAGMENT_ADD:
                fragmentTransaction.add(containerViewId, fragment).commit();
                break;
            case FRAGMENT_REPlACE:
                fragmentTransaction.replace(containerViewId, fragment).commit();
                break;
            case FRAGMENT_REMOVE:
                fragmentTransaction.remove(fragment).commit();
                break;
            default:
                break;
        }
    }

    public void selectFragment(TabType tabType) {
        switch (tabType) {
            case NEWS:
                if (mCurrentFragmentType != TabType.NEWS) {
                    if (null == mNewsFragment) {
                        mNewsFragment = new NewsFragment();
                    }
                    fragmentTransaction(FragmentTransactionType.FRAGMENT_REPlACE, mNewsFragment, R.id.activity_main_content);
                }
                break;
            case MYPUBLISH:
                if (mCurrentFragmentType != TabType.MYPUBLISH) {
                    if (null == mMyPublishFragment) {
                        mMyPublishFragment = new MyPublishFragment();
                    }
                    fragmentTransaction(FragmentTransactionType.FRAGMENT_REPlACE, mMyPublishFragment, R.id.activity_main_content);
                }
                break;
            case SETTING:
                if (mCurrentFragmentType != TabType.SETTING) {
                    if (null == mSettingFragment) {
                        mSettingFragment = new SettingFragment();
                    }
                    fragmentTransaction(FragmentTransactionType.FRAGMENT_REPlACE, mSettingFragment, R.id.activity_main_content);
                }
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
