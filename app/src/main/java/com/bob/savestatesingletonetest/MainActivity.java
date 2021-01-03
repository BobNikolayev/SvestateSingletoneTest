package com.bob.savestatesingletonetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final String COUNTER_KAY = "COUNTER_KAY";
    public TextView counterText;
    public Button counterBtn;
    public int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainPresenter instance = MainPresenter.getInstance();

        counterText = findViewById(R.id.counterView);
        counterBtn = findViewById(R.id.counterButton);

        counterText.setText(String.valueOf(instance.getCounter()));

        if(savedInstanceState != null){
            Toast.makeText(getApplicationContext(),"Second Start", Toast.LENGTH_SHORT).show();
//            counter = savedInstanceState.getInt(COUNTER_KAY);
            counterText.setText(String.valueOf(instance.getCounter()));
        }

//        counterText.setText(String.valueOf(counter));

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    instance.incrementCounter();
                    counterText.setText(String.valueOf(instance.getCounter()));
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
}