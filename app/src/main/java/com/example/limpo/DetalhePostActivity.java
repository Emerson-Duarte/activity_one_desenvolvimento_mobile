package com.example.limpo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.limpo.model.Posts;

public class DetalhePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_posts);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objPosts");
        Posts posts = intent.getParcelableExtra("objPosts");
        bind(posts);

    }
    private void bind(Posts obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText("ID: "+obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText("ID USER: "+obj.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        tv = findViewById(R.id.tvBody);
        tv.setText(obj.getBody());
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this,MainPage.class);
        startActivity(intent);
    }
}