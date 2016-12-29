package com.qf.nwt.application.fragment.msgcenterfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.nwt.application.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MsgCenterFragment extends Fragment {


    public MsgCenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg_center, container, false);
        return view;
    }

}
