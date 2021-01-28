package com.example.sqlcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private Button btnList;
    FloatingActionButton btnAddChallenge;

    public static SQLiteHelper sqLiteHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteHelper = new SQLiteHelper(this, "ChallengesDB.sqlite", null, 1);

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Challenge(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, image BLOB,days VARCHAR, description VARCHAR)");

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS MyChallenge(MyCid INTEGER PRIMARY KEY AUTOINCREMENT,CId INTEGER, name VARCHAR, image BLOB,days VARCHAR, description VARCHAR,is_Done VARCHAR, start_date VARCHAR )");

        btnAddChallenge =  (FloatingActionButton) findViewById(R.id.btnAddC);
        btnList= (Button) findViewById(R.id.List);
        btnAddChallenge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChallengeList.class);
                startActivity(intent);
            }
        });

    }
    public SQLiteHelper getHelper(){return sqLiteHelper;}
}