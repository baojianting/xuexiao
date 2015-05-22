package com.dabao.xuexiao.setting;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabao.xuexiao.R;
import com.dabao.xuexiao.common.Logger;

/**
 * Created by baojianting on 2015/5/21.
 */
public class SettingFragment extends Fragment {

    private static final String TAG = "SettingFragment";

    public SettingFragment() {
        Logger.getInstance().error(TAG, "construct");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Logger.getInstance().error(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.getInstance().error(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_setting, null);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
