package com.android.implicitquotessharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView quotes;
    Button next, prev, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        quotes= (TextView)findViewById(R.id.quote2);
        next = (Button)findViewById(R.id.next2);
        prev = (Button)findViewById(R.id.prev1);
        share = (Button)findViewById(R.id.button2);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qq= quotes.getText().toString();
                Intent SI= new Intent();
                SI.setAction(Intent.ACTION_SEND);
                SI.setType("text/plain");
                SI.putExtra(Intent.EXTRA_TEXT,qq);
                startActivity(SI);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(i);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}