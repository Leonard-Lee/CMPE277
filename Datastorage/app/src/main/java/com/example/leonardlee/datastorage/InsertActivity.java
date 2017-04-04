package com.example.leonardlee.datastorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by leonardlee on 04/04/2017.
 */

public class InsertActivity extends AppCompatActivity {
    EditText txtName;
    EditText txtDescription;
    EditText txtPrice;
    EditText txtReview;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        txtName = (EditText)findViewById(R.id.txtName);
        txtDescription = (EditText)findViewById(R.id.txtDescription);
        txtPrice = (EditText)findViewById(R.id.txtPrice);
        txtReview = (EditText)findViewById(R.id.txtReview);

        db = new DBHelper(this);
    }

    public void btnInsertClicked(View view) {
        String name = txtName.getText().toString();
        String description = txtDescription.getText().toString();
        String price = txtDescription.getText().toString();
        String review = txtReview.getText().toString();

        if(db.insertContact(name, description, price, review)){
            Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnCancelClicked(View view) {
        txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtReview.setText("");
    }
}
