package com.crunch.kevin.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityB extends AppCompatActivity {

    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        count=bundle.getInt("counter");
    }

    public void FinB(View view){
        Intent intent=new Intent(ActivityB.this,ActivityA.class);
        intent.putExtra("counter",count);
        startActivity(intent);
        ActivityB.this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        count=bundle.getInt("counter");
        count++;
    }
}
