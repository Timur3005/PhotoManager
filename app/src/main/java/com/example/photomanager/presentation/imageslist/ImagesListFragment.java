package com.example.photomanager.presentation.imageslist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.photomanager.PhotoManagerApp;
import com.example.photomanager.R;
import com.example.photomanager.data.ImageDatabase;
import com.example.photomanager.data.ImageRepositoryImpl;
import com.example.photomanager.databinding.FragmentImagesListBinding;
import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.presentation.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class ImagesListFragment extends Fragment {

    private ImagesListViewModel viewModel;

    @Inject
    public ViewModelFactory viewModelFactory;
    @Inject
    public ImageItemAdapter adapter;

    private FragmentImagesListBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((PhotoManagerApp)getActivity().getApplication()).component.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentImagesListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(ImagesListViewModel.class);
        binding.addPhoto.setOnClickListener(view1 -> navigateToImageItemFragment());
        setupRecycler();
        viewModel.getImages().observe(getViewLifecycleOwner(), imageItems -> {
            adapter.submitList(imageItems);
        });
        setupSwipeListenerForImageItems(binding.imageItemsRecycler);
    }

    private void navigateToImageItemFragment(){
        Navigation.findNavController(requireView()).navigate(R.id.action_imagesListFragment_to_imageItemFragment);
    }

    private void setupRecycler(){
        binding.imageItemsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.imageItemsRecycler.setAdapter(adapter);
    }

    private void setupSwipeListenerForImageItems(RecyclerView recyclerView){
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                ImageItem imageItem = adapter.getCurrentList().get(viewHolder.getBindingAdapterPosition());
                viewModel.deleteImageItem(imageItem);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

}