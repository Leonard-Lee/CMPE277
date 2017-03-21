package com.example.leonardlee.farmmaintenance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtFan;
    private TextView txtSprinkler;
    private Receiver receiver;
    private boolean isFanOn = false;
    private boolean isSprinklerOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFan = (TextView)findViewById(R.id.txtFan);
        txtSprinkler = (TextView)findViewById(R.id.txtSprinkler);

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.leonardlee.intent.FANON");
        filter.addAction("com.leonardlee.intent.FANSPRINKLERON");
        filter.addAction("com.leonardlee.intent.FANTURN");
        filter.addAction("com.leonardlee.intent.FANSPRINKLERTURN");

        receiver = new Receiver();
        registerReceiver(receiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private class Receiver extends BroadcastReceiver {
        public Receiver() {

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.leonardlee.intent.FANON")) {
                txtFan.setText("FAN ON");
                isFanOn = true;
            }
            else if (intent.getAction().equals("com.leonardlee.intent.FANSPRINKLERON")) {
                txtFan.setText("FAN ON");
                isFanOn = true;

                txtSprinkler.setText("SPRINKLER ON");
                isSprinklerOn = true;
            }
            else if (intent.getAction().equals("com.leonardlee.intent.FANTURN")) {
                isFanOn = !isFanOn;

                if(isFanOn) {
                    txtFan.setText("FAN ON");
                }
                else {
                    txtFan.setText("FAN OFF");
                }
            }
            else if (intent.getAction().equals("com.leonardlee.intent.FANSPRINKLERTURN")) {
                isFanOn = !isFanOn;
                isSprinklerOn = !isSprinklerOn;

                if(isFanOn) {
                    txtFan.setText("FAN ON");
                }
                else {
                    txtFan.setText("FAN OFF");
                }

                if(isSprinklerOn) {
                    txtSprinkler.setText("SPRINKLER ON");
                }
                else {
                    txtSprinkler.setText("SPRINKLER OFF");
                }
            }
        }
    }
}
