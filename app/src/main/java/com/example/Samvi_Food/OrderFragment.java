package com.example.Samvi_Food;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.Samvi_Food.login_signup.My_cart;

public class OrderFragment extends Fragment{
    private ImageView button;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.orderfragment, container, false);
        button = rootView.findViewById(R.id.imga);
        textView=rootView.findViewById(R.id.markete);

textView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(getActivity(), Market.class);
        startActivity(intent);

    }
});
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {

                Intent intent = new Intent(getActivity(), My_cart.class);
                startActivity(intent);
            }



        });
        return rootView;

        }



}

