package com.example.android.newmoves;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.android.newmoves.utilities.NetworkUtils;

import java.net.URL;

public class MainActivity extends AppCompatActivity  {


    String[] items = new String[]{"Top rated Movies", "Upcoming Movies",
            "Popular Movies", "Latest Movies"};
    URL finalUrl;
    Button go;
    String url;
    public static final String EXTRA_TEXT ="url";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dropdown = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                switch (position) {
                    case 0:
                        finalUrl = NetworkUtils.buildUrl("top_rated");
                        break;
                    case 1:
                        finalUrl = NetworkUtils.buildUrl("upcoming");
                        break;
                    case 2:
                        finalUrl = NetworkUtils.buildUrl("popular");
                        break;

                    case 3:
                        finalUrl = NetworkUtils.buildUrl("latest");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                finalUrl = NetworkUtils.buildUrl("top_rated");

            }
        });



        go = (Button) findViewById(R.id.button);
        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ResultsActivity.class);
                intent.putExtra(EXTRA_TEXT, finalUrl.toString());
                startActivity(intent);

            }
        });


    }



    }



