package com.example.limpo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.limpo.R;
import com.example.limpo.model.Photos;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<Photos> listaPhotos;

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        public View viewPhoto;


        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPhoto = itemView;
        }
    }
    public PhotoAdapter(List<Photos> photos) {
        this.listaPhotos = photos;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_photo, parent, false);
        return new PhotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.PhotoViewHolder holder, int position) {
        Photos obj = this.listaPhotos.get(position);
        TextView tv = holder.viewPhoto.findViewById(R.id.tvId);
        tv.setText("ID: " +obj.getId()+"");
        tv = holder.viewPhoto.findViewById(R.id.tvAlbumId);
        tv.setText("Album Id: "+obj.getAlbumId()+"");
        tv = holder.viewPhoto.findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        tv = holder.viewPhoto.findViewById(R.id.tvUrl);
        tv.setText(obj.getUrl());
        tv = holder.viewPhoto.findViewById(R.id.tvThumbnailUrl);
        tv.setText(obj.getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return this.listaPhotos.size();
    }
}
