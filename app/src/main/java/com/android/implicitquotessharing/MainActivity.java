package com.android.implicitquotessharing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView q1;
    Button share;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        q1= (TextView)findViewById(R.id.quote);
        share=(Button)findViewById(R.id.button);
        next = (Button)findViewById(R.id.next1);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qq= q1.getText().toString();
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
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Really want to Exit App")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No",null).setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }
}