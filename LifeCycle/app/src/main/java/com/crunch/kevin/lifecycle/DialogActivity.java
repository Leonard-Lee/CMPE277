package com.crunch.kevin.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class DialogActivity extends Activity {

    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        count=bundle.getInt("counter");
    }

    public void FinDia(View view){
        Intent intent=new Intent(DialogActivity.this,ActivityA.class);
        intent.putExtra("counter",count);
        startActivity(intent);
        DialogActivity.this.finish();
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
