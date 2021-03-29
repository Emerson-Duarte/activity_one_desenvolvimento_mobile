package com.example.limpo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.limpo.model.Albums;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.example.limpo.model.Albums;

public class ListAlbums extends AppCompatActivity
    implements Response.Listener<JSONArray>,
            Response.ErrorListener {

        List<Albums> albums = new ArrayList<>();
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent it = getIntent();

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/albums";

        // Request de JsonArray da URL.

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this, this);


        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);

        ImageButton back = (ImageButton) findViewById(R.id.imageButton);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                backToLogin(v);
            }

        });

    }
// Volley
        @Override
        public void onResponse (JSONArray response){
        try {

            for (int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Albums obj = new Albums(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"));
                albums.add(obj);

            }
            Toast.makeText(this, "qtd:" + albums.size(), Toast.LENGTH_LONG).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);
            for (Albums obj1 : albums) {
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = (Button) v;
                        Albums Albums = (Albums) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalheAlbumActivity.class);

                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objAlbum", Albums);
                        // lança intent para o SO chamar a activity
                        startActivity(intent);
                    }
                });
                ll.addView(bt);
            }


        } catch (JSONException e) {
            Log.e("erro", e.getMessage());
            e.printStackTrace();
        }
    }

        @Override
        public void onErrorResponse (VolleyError error){
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(), "deu erro: " + msg, Toast.LENGTH_LONG).show();
    }

        public void backToLogin(View view) {
            Intent intent = new Intent(this,MainPage.class);
            startActivity(intent);
        }
}