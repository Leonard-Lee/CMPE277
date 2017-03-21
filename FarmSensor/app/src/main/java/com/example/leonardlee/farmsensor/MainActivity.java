package com.example.leonardlee.farmsensor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtTemperature;
    private EditText txtHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTemperature = (EditText)findViewById(R.id.txtTemperature);
        txtHumidity = (EditText)findViewById(R.id.txtHumidity);
    }

    public void btnSetClicked(View view) {
        String temp = txtTemperature.getText().toString();
        String humid = txtHumidity.getText().toString();

        if(temp.equals("")) {
            Toast.makeText(this, "Please enter the value of temperature", Toast.LENGTH_LONG).show();
        }
        else if(humid.equals("")) {
            Toast.makeText(this, "Please enter the value of humidity", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent("com.leonardlee.intent.sensor");
            intent.putExtra("TEMP", Integer.parseInt(temp));
            intent.putExtra("HUMID", Integer.parseInt(humid));
            sendBroadcast(intent);
        }
    }

    public void btnCancelClicked(View view) {
        txtTemperature.setText("");
        txtHumidity.setText("");
    }
}
