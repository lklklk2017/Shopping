package com.qf.nwt.application.fragment.loginfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.nwt.application.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PwdLoginFragment extends Fragment {


    public PwdLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pwd_login, container, false);
    }

}
