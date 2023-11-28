package com.example.photomanager.presentation.imageitem;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.photomanager.PhotoManagerApp;
import com.example.photomanager.databinding.FragmentImageItemBinding;
import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.presentation.ViewModelFactory;

import javax.inject.Inject;

public class ImageItemFragment extends Fragment {

    private FragmentImageItemBinding binding;
    private Uri photoUri;

    private ImageItemViewModel viewModel;

    @Inject
    public ViewModelFactory viewModelFactory;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((PhotoManagerApp)getActivity().getApplication()).component.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentImageItemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, viewModelFactory)
                .get(ImageItemViewModel.class);
        chosePhoto();
        binding.save.setOnClickListener(view1 -> {
            viewModel.insertImageItem(new ImageItem(
                    binding.nameOfImage.getText().toString(),
                    binding.descriptionOfImage.getText().toString(),
                    photoUri.toString()));
        });
    }

    private void chosePhoto() {
        ActivityResultLauncher<PickVisualMediaRequest> pickMedia =
                registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                    if (uri != null) {
                        photoUri = uri;
                        Glide.with(this).load(photoUri).into(binding.image);
                    }
                    else{
                        Navigation.findNavController(requireView()).popBackStack();
                    }
                });
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                .build());
    }

}