package com.example.leonardlee.iotasynctask;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncResponse{
    IoTAsyncTask asyncTask;
    EditText txtNum;
    EditText txtTemperature;
    EditText txtHumidity;
    EditText txtActivity;
    EditText txtOutput;

    Button btnGenerate;
    Button btnCancel;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNum = (EditText) findViewById(R.id.txtNum) ;
        txtTemperature = (EditText) findViewById(R.id.txtTemperature);
        txtHumidity = (EditText) findViewById(R.id.txtHumility);
        txtActivity = (EditText) findViewById(R.id.txtActivity);
        txtOutput = (EditText) findViewById(R.id.txtOutput);

        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        counter = 0;
    }

//    this override the implemented method from asyncTask
    @Override
    public void processInProgress(SensorData output){
        //Here you will receive the result fired from async class
        //of onPostExecute(result) method.
        String strTemp = String.format("%d F", output.getTeperature());
        txtTemperature.setText(strTemp);

        String strHumi = String.format("%d %%", output.getHumidity());
        txtHumidity.setText(strHumi);

        String strAct = String.format("%d", output.getActivity());
        txtActivity.setText(strAct);
        Toast.makeText(this, "new random message comes in", Toast.LENGTH_SHORT).show();

        counter++;
        StringBuilder sb = new StringBuilder();
        sb.append("Output ").append(counter + ":\n");
        sb.append("Temperature: ").append(strTemp + "\n");
        sb.append("Humidity: ").append(strHumi + "\n");
        sb.append("Activity: ").append(strAct + " \n\n");
        txtOutput.append(sb.toString());
    }

    public void btnGenClicked(View view) {
        counter = 0;
        int num = Integer.parseInt(txtNum.getText().toString());
        //AsyncTask
        asyncTask = new IoTAsyncTask();
        asyncTask.delegate = this;
        asyncTask.execute(num);

        btnGenerate.setClickable(false);
        btnCancel.setClickable(true);
    }

    public void btnCancelClicked(View view) {
        asyncTask.cancel(false);

        txtTemperature.setText("");
        txtHumidity.setText("");
        txtActivity.setText("");
        txtNum.setText("");
        txtOutput.setText("");

        btnGenerate.setClickable(true);
        btnCancel.setClickable(false);
    }
}
