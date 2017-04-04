package com.example.leonardlee.datastorage;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by leonardlee on 04/04/2017.
 */

public class SearchActivity extends AppCompatActivity {
    EditText txtSearch;
    EditText txtOutput;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        txtSearch = (EditText)findViewById(R.id.txtSearch);
        txtOutput = (EditText)findViewById(R.id.txtOutput);
        db = new DBHelper(this);
    }

    public void btnSearchClicked(View view) {
        Cursor rs = db.getData(txtSearch.getText().toString());
        rs.moveToFirst();

        String name = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
        String description = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_DESCRIPTION));
        String price = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PRICE));
        String review = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_REVIEW));

        if (!rs.isClosed())  {
            rs.close();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Output ").append("\n");
        sb.append("Name: ").append(name + "\n");
        sb.append("Description: ").append(description + "\n");
        sb.append("Price: ").append(price + "\n");
        sb.append("Review: ").append(review + " \n\n");

        txtOutput.setText(sb.toString());
    }

    public void btnCancelClicked(View view) {
        txtSearch.setText("");
        txtOutput.setText("");
    }
}
