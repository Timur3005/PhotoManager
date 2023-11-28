package com.example.photomanager.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.bumptech.glide.Glide;
import com.example.photomanager.databinding.ImageItemBinding;
import com.example.photomanager.domain.ImageItem;

import javax.inject.Inject;

public class ImageItemAdapter extends ListAdapter<ImageItem, ImageItemViewHolder> {
    @Inject
    ImageItemAdapter() {
        super(new DiffUtil.ItemCallback<ImageItem>() {
            @Override
            public boolean areItemsTheSame(@NonNull ImageItem oldItem, @NonNull ImageItem newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull ImageItem oldItem, @NonNull ImageItem newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public ImageItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageItemViewHolder(ImageItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageItemViewHolder holder, int position) {
        ImageItemBinding binding = holder.binding;
        ImageItem imageItem = getItem(position);
        Glide.with(binding.getRoot().getContext()).load(imageItem.photoPath).into(binding.image);
        binding.name.setText(imageItem.name);
    }
}
