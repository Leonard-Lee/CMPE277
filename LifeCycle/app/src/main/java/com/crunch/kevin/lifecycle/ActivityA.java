package com.crunch.kevin.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {

    private TextView tv;
    private int count=0000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        tv=(TextView)findViewById(R.id.textView2);
//        Intent intent=getIntent();
//        Bundle bundle=intent.getExtras();
//        count=bundle.getInt("counter");
    }

    public void GoB(View view){
        Intent intent=new Intent(ActivityA.this,ActivityB.class);
        intent.putExtra("counter",count);
        startActivity(intent);
        ActivityA.this.finish();
    }

    public void GoDia(View view ){
        Intent intent=new Intent(ActivityA.this,DialogActivity.class);
        intent.putExtra("counter",count);
        startActivity(intent);
        ActivityA.this.finish();
    }

    public void Close(View view){
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null)
        count=bundle.getInt("counter");
        count++;
        tv.setText(String.valueOf(count));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
