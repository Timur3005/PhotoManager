package com.example.photomanager.presentation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.photomanager.R;
import com.example.photomanager.databinding.FragmentImageItemBinding;

public class ImageItemFragment extends Fragment {

    private FragmentImageItemBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentImageItemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

}