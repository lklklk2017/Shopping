package com.qf.nwt.application.fragment.loginfragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.qf.nwt.application.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CodeLoginFragment extends Fragment {


    private String phone;
    private View view;
    private EditText ed_telNumber;

    public CodeLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_code_login, container, false);
        findViewID();
//        ed_telNumber.setText(phone);
        return view;
    }

    /**
     * 找id
     */
    private void findViewID() {
        ed_telNumber = (EditText) view.findViewById(R.id.ed_telNumber);
    }

}
