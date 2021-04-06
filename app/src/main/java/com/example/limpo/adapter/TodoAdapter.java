package com.example.limpo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.limpo.R;
import com.example.limpo.model.Todos;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todos> listaTodos;

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        public View viewTodo;


        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewTodo = itemView;
        }
    }
    public TodoAdapter(List<Todos> todos) {
        this.listaTodos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_todo, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.TodoViewHolder holder, int position) {
        Todos obj = this.listaTodos.get(position);
        TextView tv = holder.viewTodo.findViewById(R.id.tvId);
        tv.setText("ID: "+obj.getId()+"");
        tv = holder.viewTodo.findViewById(R.id.tvIdUser);
        tv.setText("ID USER: "+obj.getUserId()+"");
        tv = holder.viewTodo.findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        CheckBox cb = holder.viewTodo.findViewById(R.id.cbCompleted);
        cb.setChecked(obj.isCompleted());
    }

    @Override
    public int getItemCount() {
        return this.listaTodos.size();
    }
}
