package com.example.limpo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.limpo.model.Todos;

public class DetalheTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todo);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objTodo");
        Todos todos = intent.getParcelableExtra("objTodo");
        bind(todos);

    }
    public void cbClick(View v) {
        CheckBox cb = findViewById(R.id.cbCompleted);
        Intent intent = getIntent();
        Todos todo = intent.getParcelableExtra("objTodo");
        todo.setCompleted(cb.isChecked());
    }
    private void bind(Todos obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText("ID: "+obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText("ID USER: "+obj.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        CheckBox cb = findViewById(R.id.cbCompleted);
        cb.setChecked(obj.isCompleted());

    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this,MainPage.class);
        startActivity(intent);
    }
}