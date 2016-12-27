package com.qf.nwt.application.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qf.nwt.application.R;
import com.qf.nwt.application.activity.SettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Me extends Fragment implements View.OnClickListener {


    private View view;
    private ImageView img_setting;

    public Me() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        findViewID();
        initListener();
        return view;
    }

    private void initListener() {
        img_setting.setOnClickListener(this);
    }

    /**
     * 找id
     */
    private void findViewID() {
        img_setting = (ImageView) view.findViewById(R.id.img_setting);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击设置
            case R.id.img_setting:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
