package com.example.limpo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.limpo.R;
import com.example.limpo.model.Albums;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<Albums> listaAlbums;

    public class AlbumViewHolder extends RecyclerView.ViewHolder {

        public View viewAlbum;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewAlbum = itemView;
        }
    }
    public AlbumAdapter(List<Albums> albums) {
        this.listaAlbums = albums;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_album, parent, false);
        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Albums obj = this.listaAlbums.get(position);
        TextView tv = holder.viewAlbum.findViewById(R.id.tvId);
        tv.setText("ID: "+obj.getId()+"");
        tv = holder.viewAlbum.findViewById(R.id.tvIdUser);
        tv.setText("ID USER: "+obj.getUserId()+"");
        tv = holder.viewAlbum.findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());


    }

    @Override
    public int getItemCount() {
        return this.listaAlbums.size();
    }
}
