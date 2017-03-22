package com.example.leonardlee.activitylifecycle;

//import android.support.v4.widget.TextViewCompat;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private int count;

    // Android life cycle event
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView)findViewById(R.id.txtCounter);
        count = 1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            count = bundle.getInt("count");
            count ++;
            String strCount = String.format("Thread Counter: %04d", count);
            txtView.setText(strCount);
        }
    }

    // btn clicked to direct to another activity, Activity B
    public void btnActivityBClicked(View view) {
        Intent intent = new Intent(MainActivity.this, BActivity.class);
        intent.putExtra("count", count);
        startActivity(intent);
        MainActivity.this.finish();
    }

    // btn clicked to direct to another activity, Dialog
    public void btnDialogClicked(View view) {
        Intent intent = new Intent(MainActivity.this, DialogActivity.class);
        intent.putExtra("count", count);
        startActivity(intent);
        MainActivity.this.finish();
    }

    // btn finish the app
    public void btnFinishClicked(View view) {
        finish();
    }
}
