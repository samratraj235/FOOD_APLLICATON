package com.example.Samvi_Food;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
ImageView chat;
TextView btPicker;
ImageView pay;
TextView textView;
int PLACE_PICKER_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btPicker=findViewById(R.id.bt_picker);
         textView=findViewById(R.id.text_view);

         chat=findViewById(R.id.scan);
         pay=findViewById(R.id.paym);
         pay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent =new Intent(MainActivity.this,payment_option.class);
                 startActivity(intent);
             }
         });




        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,customersupport.class);
                startActivity(intent);
            }
        });
       btPicker.setOnClickListener(new View.OnClickListener() {


           @Override
           public void onClick(View v) {
               PlacePicker.IntentBuilder builder=new PlacePicker.IntentBuilder();
               try {
                   startActivityForResult(builder.build(MainActivity.this),PLACE_PICKER_REQUEST);
               } catch (GooglePlayServicesRepairableException e) {
                   e.printStackTrace();
               } catch (GooglePlayServicesNotAvailableException e) {
                   e.printStackTrace();
               }


           }
       });

        //loading the default fragment
        loadFragment(new OrderFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);

        navigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (requestCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                StringBuilder stringBuilder = new StringBuilder();
                String latitude = String.valueOf(place.getLatLng().latitude);
                String longitude = String.valueOf(place.getLatLng().longitude);
                stringBuilder.append("LATITUDE:");
                stringBuilder.append(latitude);
                stringBuilder.append("\n");
                stringBuilder.append("LONGITUDE:");
                stringBuilder.append(longitude);
                textView.setText(stringBuilder.toString());


            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_order:
                fragment = new OrderFragment();


                break;

            case R.id.nav_exp:

                fragment = new ExplooreFragment();

                break;


            case R.id.nav_profile:
                fragment = new ProfileFragment();

                break;


        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }



    }
