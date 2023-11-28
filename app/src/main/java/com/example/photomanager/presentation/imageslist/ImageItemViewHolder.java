package com.example.photomanager.presentation.imageslist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photomanager.databinding.ImageItemBinding;

public class ImageItemViewHolder extends RecyclerView.ViewHolder {
    ImageItemBinding binding;
    public ImageItemViewHolder(@NonNull ImageItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
