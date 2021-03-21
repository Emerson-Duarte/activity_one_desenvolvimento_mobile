package com.example.limpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button login = (Button) findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openMainPage(v);

            }

        });
    }

    public void openMainPage(View view) {
        Intent intent = new Intent(this,MainPage.class);
        EditText loginName = (EditText)findViewById(R.id.editTextTextPersonName2);
        String qq = loginName.getText().toString();
        EditText password = (EditText)findViewById(R.id.editTextTextPassword);
        String ww = password.getText().toString();


        intent.putExtra("nome",loginName.getText().toString());


        if(qq.equals(ww)) {
            startActivity(intent);
        }else{
            Toast.makeText(this,"User and password are different!!",Toast.LENGTH_LONG).show();

        }
    }


}