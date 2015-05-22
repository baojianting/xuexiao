package com.dabao.xuexiao.publish;

import android.app.Activity;
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
public class MyPublishFragment extends Fragment {

    private static final String TAG = "MyPublishFragment";

    public MyPublishFragment() {
        Logger.getInstance().error(TAG, "construct");
    }

    @Override
    public void onAttach(Activity activity) {
        Logger.getInstance().error(TAG, "onAttach");
        super.onAttach(activity);
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
        View view = inflater.inflate(R.layout.fragment_mypublish, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Logger.getInstance().error(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        Logger.getInstance().error(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onStart() {
        Logger.getInstance().error(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        Logger.getInstance().error(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Logger.getInstance().error(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Logger.getInstance().error(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Logger.getInstance().error(TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Logger.getInstance().error(TAG, "onDetach");
        super.onDetach();
    }
}