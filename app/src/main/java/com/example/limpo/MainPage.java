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

        Button toTodos = (Button) findViewById(R.id.button3);

        toTodos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toTodos(v);
            }

        });

        Button toPosts = (Button) findViewById(R.id.button5);

        toPosts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toPosts(v);
            }

        });

        Button toAlbums = (Button) findViewById(R.id.button6);

        toAlbums.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toAlbums(v);
            }

        });

        Button toPhotos = (Button) findViewById(R.id.button7);

        toPhotos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toPhotos(v);
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

    public void toTodos(View view) {
        Intent intent = new Intent(this,ListTodo.class);
        startActivity(intent);
    }

    public void toPosts(View view) {
        Intent intent = new Intent(this,ListPosts.class);
        startActivity(intent);
    }

    public void toAlbums(View view) {
        Intent intent = new Intent(this,ListAlbums.class);
        startActivity(intent);
    }

    public void toPhotos(View view) {
        Intent intent = new Intent(this,ListPhotos.class);
        startActivity(intent);
    }
}