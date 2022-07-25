package com.example.amharicorommifa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Fragment;

public class definition extends Fragment {

    TextView m,d;
    String main="";
    String def="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_definition, container, false);

            m=view.findViewById(R.id.mainw);
            d=view.findViewById(R.id.def);


        Bundle bundle = getArguments();

        if(bundle!=null){

            main = bundle.getString("main");
            def = bundle.getString("def");



        }
        else {
            Toast.makeText(getActivity(), "No data", Toast.LENGTH_SHORT).show();
        }

        m.setText(main);
        d.setText(def);

        // Inflate the layout for this fragment
       return view;
    }
}