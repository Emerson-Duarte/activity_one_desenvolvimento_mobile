package com.example.limpo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.limpo.model.Photos;

public class DetalhePhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_photo);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objPhoto");
        Photos photos = intent.getParcelableExtra("objPhoto");
        bind(photos);

    }
    private void bind(Photos obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText("ID: " +obj.getId()+"");
        tv = findViewById(R.id.tvAlbumId);
        tv.setText("Album Id: "+obj.getAlbumId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        tv = findViewById(R.id.tvUrl);
        tv.setText(obj.getUrl());
        tv = findViewById(R.id.tvThumbnailUrl);
        tv.setText(obj.getThumbnailUrl());
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this,MainPage.class);
        startActivity(intent);
    }
}