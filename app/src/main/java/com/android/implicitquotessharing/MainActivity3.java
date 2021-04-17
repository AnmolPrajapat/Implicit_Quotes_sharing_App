package com.android.implicitquotessharing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    TextView qqq;
    Button share,hint,prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        qqq= (TextView)findViewById(R.id.quote3);
        share= (Button)findViewById(R.id.button3);
        hint=(Button)findViewById(R.id.hint);
        prev=(Button)findViewById(R.id.prevLast);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qq= qqq.getText().toString();
                Intent SI= new Intent();
                SI.setAction(Intent.ACTION_SEND);
                SI.setType("text/plain");
                SI.putExtra(Intent.EXTRA_TEXT,qq);
                startActivity(SI);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(i);
            }
        });
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this," This quote you said when i asked you about expected percentange you want and you said that...are you remember this",Toast.LENGTH_LONG).show();

            }
        });
    }

}