package com.example.leonardlee.farmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by leonardlee on 12/03/2017.
 */

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int temp = intent.getExtras().getInt("TEMP");
        Log.d("TEMP", Integer.toString(temp));
        int humid = intent.getExtras().getInt("HUMID");
        Log.d("HUMID", Integer.toString(humid));

        if(temp > 70 && temp < 90) {
            // turn on the fan
            Intent broadcastIntent = new Intent("com.leonardlee.intent.FANON");
            context.sendBroadcast(broadcastIntent);
            Log.d("BROADCAST", "Send the broadcast");
        }
        else if(temp > 90 && temp < 125) {
            // turn on the fan and sprinkler
            Intent broadcastIntent = new Intent("com.leonardlee.intent.FANSPRINKLERON");
            context.sendBroadcast(broadcastIntent);
            Log.d("BROADCAST", "Send the broadcast");
        }
    }
}
