package com.bob.savestatesingletonetest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ConstantKeys {


    public TextView counterText;
    public Button counterBtn;
    public Button counterChanger;
    public int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainPresenter presenter = MainPresenter.getInstance();

        counterText = findViewById(R.id.counterView);
        counterBtn = findViewById(R.id.counterButton);
        counterChanger = findViewById(R.id.counterСhangerBtn);

        counterChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parcel parcel = new Parcel();

                parcel.counter = Integer.parseInt(counterText.getText().toString());

                Intent intent  = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra(COUNTER_KAY,parcel);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        counterText.setText(String.valueOf(presenter.getCounter()));

        if(savedInstanceState != null){
            Toast.makeText(getApplicationContext(),"Second Start", Toast.LENGTH_SHORT).show();
//            counter = savedInstanceState.getInt(COUNTER_KEY);
            counterText.setText(String.valueOf(presenter.getCounter()));
        }

//        counterText.setText(String.valueOf(counter));

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    presenter.incrementCounter();
                    counterText.setText(String.valueOf(presenter.getCounter()));
//                counter++;
//                counterText.setText(String.valueOf(counter));
            }
        };
        counterBtn.setOnClickListener(onClickListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        outState.putInt(COUNTER_KAY,counter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode != REQUEST_CODE){
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if(resultCode == RESULT_OK){
            counterText.setText(data.getStringExtra(COUNTER_RESULT));
            final MainPresenter presenter =  MainPresenter.getInstance();
            presenter.setCounter(counterText.getText().toString());

        }

    }
}