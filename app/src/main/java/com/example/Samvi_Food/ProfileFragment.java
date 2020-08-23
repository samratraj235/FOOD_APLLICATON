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

public class ProfileFragment extends Fragment{
    private TextView button;
    private TextView paym;
    private TextView textView;
    private TextView noti;
    private TextView ord;
    private TextView adr;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.profilefragment, container, false);
        button = rootView.findViewById(R.id.wallett);
        textView=rootView.findViewById(R.id.bk);
        paym=rootView.findViewById(R.id.pay);
        noti=rootView.findViewById(R.id.notification);
        ord=rootView.findViewById(R.id.order);
        adr=rootView.findViewById(R.id.adress);
        adr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Adress_book.class);
                startActivity(intent);

            }
        });
        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),your_order.class);
                startActivity(intent);
            }
        });
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),notifiicationget.class);
                startActivity(intent);
            }
        });
        paym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),payment_option.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),walletl.class);
                startActivity(intent);
            }
        });

      textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(getActivity(),bookmarkfr.class);
                  startActivity(intent);
          }
      });
        return rootView;

    }



}

