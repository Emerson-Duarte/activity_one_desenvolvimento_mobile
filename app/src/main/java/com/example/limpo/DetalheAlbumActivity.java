package com.example.limpo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.limpo.model.Albums;


public class DetalheAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_album);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objAlbum");
        Albums albums = intent.getParcelableExtra("objAlbum");
        bind(albums);

    }
    private void bind(Albums obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText("ID: "+obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText("ID USER: "+obj.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
    }

    public void toAlbums(View view) {
        Intent intent = new Intent(this,ListAlbums.class);
        startActivity(intent);
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this,MainPage.class);
        startActivity(intent);
    }
}