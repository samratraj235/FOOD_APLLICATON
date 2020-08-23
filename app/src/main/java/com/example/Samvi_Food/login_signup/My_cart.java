package com.example.Samvi_Food.login_signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Samvi_Food.MainActivity;
import com.example.Samvi_Food.Order_place;
import com.example.Samvi_Food.R;

public class My_cart extends AppCompatActivity {
    ImageButton img;
    TextView place;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_cart);
        img=findViewById(R.id.bck);
        place=findViewById(R.id.placetext);
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(My_cart.this, Order_place.class);
                startActivity(intent);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(My_cart.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

}
