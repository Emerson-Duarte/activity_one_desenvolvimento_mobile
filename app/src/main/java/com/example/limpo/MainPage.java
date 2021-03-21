package com.example.limpo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = getIntent();
        String txt = it.getStringExtra("nome");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("Bem-vindo, " + txt + "!!!");


        ImageButton back = (ImageButton) findViewById(R.id.imageButton);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                backToLogin(v);
            }

        });

        Button restart = (Button) findViewById(R.id.button2);

        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                restartApplication(v);
            }

        });
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this,Launcher.class);
        startActivity(intent);
    }

    public void restartApplication(View view) {
        Intent intent = new Intent(this,SplashScreen.class);
        startActivity(intent);
    }
}