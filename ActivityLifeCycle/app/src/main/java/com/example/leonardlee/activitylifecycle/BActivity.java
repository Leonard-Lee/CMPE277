package com.example.leonardlee.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by leonardlee on 06/03/2017.
 */

public class BActivity extends AppCompatActivity{
    // Android life cycle events
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
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

    public void btnFinishClicked(View view) {
        Intent intent = new Intent(BActivity.this, MainActivity.class);
        intent.putExtra("count", count);
        startActivity(intent);
        BActivity.this.finish();
    }
}
