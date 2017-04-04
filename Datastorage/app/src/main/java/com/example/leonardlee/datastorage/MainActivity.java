package com.example.leonardlee.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // transfer to Search activity
    public void btnInsertClicked(View view) {
        Intent intent = new Intent(MainActivity.this, InsertActivity.class);
        startActivity(intent);
        // can not return to the main page
        // MainActivity.this.finish();
    }

    // transfer to Insert activity
    public void btnSearchClicked(View view) {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
        // can not return to the main page
        // MainActivity.this.finish();
    }
}
