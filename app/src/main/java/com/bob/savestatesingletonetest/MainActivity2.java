package com.bob.savestatesingletonetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity implements ConstantKeys {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText editCounter = findViewById(R.id.editCounter);
        Button changeCounterBtn = findViewById(R.id.counterСhangerBtn);

        Parcel parcel = (Parcel) getIntent().getExtras().getSerializable(COUNTER_KAY);

        editCounter.setText(String.valueOf(parcel.counter));

        changeCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = new Intent();

                intentResult.putExtra(COUNTER_RESULT,String.valueOf(editCounter.getText()));
                setResult(RESULT_OK,intentResult);
                finish();
            }
        });
    }
}