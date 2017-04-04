package com.example.leonardlee.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText txtURL1, txtURL2, txtURL3, txtURL4, txtURL5;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtURL1 = (EditText)findViewById(R.id.txtURL1);
        txtURL2 = (EditText)findViewById(R.id.txtURL2);
        txtURL3 = (EditText)findViewById(R.id.txtURL3);
        txtURL4 = (EditText)findViewById(R.id.txtURL4);
        txtURL5 = (EditText)findViewById(R.id.txtURL5);

        // set up the URLs
        txtURL5.setText("http://www.cisco.com/web/offer/emear/38586/images/Presentations/P3.pdf");
        txtURL2.setText("http://www.cisco.com/web/about/ac79/docs/innov/IoE_Economy.pdf");
        txtURL3.setText("http://www.cisco.com/c/dam/en_us/solutions/industries/docs/gov/everything-for-cities.pdf");
        txtURL4.setText("http://www.cisco.com/web/offer/gist_ty2_asset/Cisco_2014_ASR.pdf");
        txtURL1.setText("http://www.cisco.com/c/dam/en_us/about/annual-report/2016-annual-report-full.pdf");

        intentFilter = new IntentFilter();
        intentFilter.addAction("FILE_DOWNLOADED_ACTION");
        registerReceiver(intentReceiver, intentFilter);
    }

    public void btnDownloadClicked(View v) {
        String url1 = txtURL1.getText().toString();
        String url2 = txtURL2.getText().toString();
        String url3 = txtURL3.getText().toString();
        String url4 = txtURL4.getText().toString();
        String url5 = txtURL5.getText().toString();

        // DownloadService IntentService
        Intent intent = new Intent(getBaseContext(), MyService.class);

        try {
            URL[] urls = new URL[] {new URL(url1), new URL(url2), new URL(url3), new URL(url4), new URL(url5)};
            intent.putExtra("URLs", urls);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Unbounded Service
        startService(intent);
    }

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getBaseContext(), "File downloaded!",
                    Toast.LENGTH_LONG).show();
        }
    };
}
