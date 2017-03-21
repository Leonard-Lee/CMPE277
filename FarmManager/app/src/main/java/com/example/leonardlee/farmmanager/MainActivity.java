package com.example.leonardlee.farmmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent broadcastIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnFanClicked(View view) {
        broadcastIntent = new Intent("com.leonardlee.intent.FANTURN");
        sendBroadcast(broadcastIntent);
        Log.d("BROADCAST", "Send the broadcast");
    }

    public void btnFanSprinklerClicked(View view) {
        broadcastIntent = new Intent("com.leonardlee.intent.FANSPRINKLERTURN");
        sendBroadcast(broadcastIntent);
        Log.d("BROADCAST", "Send the broadcast");
    }
}
