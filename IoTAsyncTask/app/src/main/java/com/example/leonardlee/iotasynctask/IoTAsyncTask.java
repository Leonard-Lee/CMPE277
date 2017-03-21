package com.example.leonardlee.iotasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import static java.lang.Thread.*;

/**
 * Created by leonardlee on 18/03/2017.
 */

public class IoTAsyncTask extends AsyncTask <Integer, SensorData, Integer> {
    public AsyncResponse delegate = null;

    @Override
//    main thread
    protected void onPreExecute() {
        super.onPreExecute();
    }

//    another thread
//    do something in background
    @Override
    protected Integer doInBackground(Integer... params) {
        int num = params[0];

        SensorData newData;
        for(int i=0; i<num; i++) {
            newData = new SensorData();
            publishProgress(newData);
            try {
                sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException("interrupted", e);
            }

            if(isCancelled()) {
                break;
            }
        }
        return 1;
    }

//    main thread
//    show progress bar
    @Override
    protected void onProgressUpdate(SensorData... values) {
        super.onProgressUpdate(values);
        delegate.processInProgress(values[0]);
    }

//    main thread
//    when finish the background job, return to the main thread
    @Override
    protected void onPostExecute(Integer value) {

        super.onPostExecute(value);
    }
}
