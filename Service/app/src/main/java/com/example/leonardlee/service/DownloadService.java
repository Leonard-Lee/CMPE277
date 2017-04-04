package com.example.leonardlee.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by leonardlee on 02/04/2017.
 */

public class DownloadService extends IntentService {

    public DownloadService() {
        super(DownloadService.class.getName());
    }

    @Override
    public void onHandleIntent(Intent intent) {
        Object[] objects = (Object[]) intent.getExtras().get("URLs");
        int count = 0;
        int progress = 0;
        URL url;

        for(int i = 0; i < objects.length; i++) {
            url = (URL)objects[i];

            try {
                count += DownloadbyURL(url);
                progress = (int) (((i+1) / (float) count) * 100);
                Toast.makeText(getBaseContext(), String.valueOf(progress) + "% downloaded",
                        Toast.LENGTH_LONG).show();
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int DownloadbyURL(URL url) throws IOException, MalformedURLException{
        InputStream inputStream = null;
        HttpURLConnection connection = null;

        connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Content-Type", "application/pdf");
        connection.setRequestProperty("Accept", "application/pdf");
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();

        if(statusCode == 200) {
            File sdcard = Environment.getExternalStorageDirectory();
            String fileName = url.toString().substring(url.toString().lastIndexOf('/') + 1);
            File file = new File(sdcard, fileName);

            FileOutputStream fileOutput = new FileOutputStream(file);
            inputStream = connection.getInputStream();

            byte[] buffer = new byte[1024];
            int bufferLength = 0;

            while((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
            }
            fileOutput.close();
            return 1;
        }
        else {
            return 0;
        }

    }
}
