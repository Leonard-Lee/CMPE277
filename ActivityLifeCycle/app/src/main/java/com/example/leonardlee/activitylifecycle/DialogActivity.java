package com.example.leonardlee.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by leonardlee on 06/03/2017.
 */

public class DialogActivity extends AppCompatActivity{
    private int count;

    // Android life cycle event
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        count = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            count = bundle.getInt("count");
            count ++;
        }
    }

    // close the dialog
    public void btnCloseClicked(View view) {
        Intent intent = new Intent(DialogActivity.this, MainActivity.class);
        intent.putExtra("count", count);
        startActivity(intent);
        DialogActivity.this.finish();
    }
}
