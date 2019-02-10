package com.example.button_counter_walling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextView counter;

    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = findViewById(R.id.counter);

        counter.setText(String.valueOf(num));

        Button increment = findViewById(R.id.increment);
        Button decrement = findViewById(R.id.decrement);
        Button reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNum(v);
            }
        });

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementNum(v);
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementNum(v);
            }
        });

    }

    public void incrementNum (View view) {
        num++;
        counter.setText(String.valueOf(num));
    }

    public void decrementNum(View view){
        num--;
        counter.setText(String.valueOf(num));
    }

    public void resetNum(View view){
        num = 0;
        counter.setText(String.valueOf(num));
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numKey", num);
    }
    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        num = bundle.getInt("numKey");
        counter.setText(String.valueOf(num));

    }

}
