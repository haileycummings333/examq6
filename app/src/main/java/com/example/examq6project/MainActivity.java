package com.example.examq6project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPopName;
    private EditText editTextPopNumber;
    private EditText editTextPopType;
    private EditText editTextFandom;
    private RadioGroup radioGroupOn;
    private EditText editTextUltimate;
    private EditText editTextPrice;
    private Button buttonSubmit;
    Cursor mCursor;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //get info from layout
            String popName= editTextPopName.getText().toString();
            int popNumber = Integer.parseInt(editTextPopNumber.getText().toString());
            String popType= editTextPopType.getText().toString();
            String fandom= editTextFandom.getText().toString();
            int selectedRadioId = radioGroupOn.getCheckedRadioButtonId();
            boolean on = (selectedRadioId == R.id.radioButtonOn);
            String ultimate= editTextUltimate.getText().toString();
            double price = Double.parseDouble(editTextPrice.getText().toString());
            // Insert the FunkoPOP object into the database
            Uri contentUri = Provider.CONTENT_URI; // Use the correct content URI
            ContentResolver contentResolver = getContentResolver();
            ContentValues values = new ContentValues();

            values.put(Provider.COLUMN_POP_NAME, popName);
            values.put(Provider.COLUMN_POP_NUMBER, popNumber);
            values.put(Provider.COLUMN_POP_TYPE, popType);
            values.put(Provider.COLUMN_FANDOM, fandom);
            values.put(Provider.COLUMN_ON, on ? 1 : 0); // Convert boolean to 1 (true) or 0 (false)
            values.put(Provider.COLUMN_ULTIMATE, ultimate);
            values.put(Provider.COLUMN_PRICE, price);

            Uri insertedUri = contentResolver.insert(contentUri, values);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize stuff from the layout
        editTextPopName = findViewById(R.id.editTextPopName);
        editTextPopNumber = findViewById(R.id.editTextPopNumber);
        editTextPopType = findViewById(R.id.editTextPopType);
        editTextFandom = findViewById(R.id.editTextFandom);
        radioGroupOn = findViewById(R.id.radioGroupOn);
        editTextUltimate = findViewById(R.id.editTextUltimate);
        editTextPrice = findViewById(R.id.editTextPrice);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(listener);
    }

}