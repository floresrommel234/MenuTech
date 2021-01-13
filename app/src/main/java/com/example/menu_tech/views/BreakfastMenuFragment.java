package com.example.menu_tech.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu_tech.R;
import com.example.menu_tech.adapters.BreakfastMenuListAdapter;
import com.example.menu_tech.databinding.FragmentBreakfastMenuBinding;
import com.example.menu_tech.models.Product;
import com.example.menu_tech.viewmodels.BreakfastMenuModel;

import java.util.List;

public class BreakfastMenuFragment extends Fragment implements BreakfastMenuListAdapter.BreakfastMenuInterface {

    FragmentBreakfastMenuBinding fragmentBreakfastMenuBinding;
    private BreakfastMenuListAdapter breakfastMenuListAdapter;
    private BreakfastMenuModel breakfastMenuModel;



    public BreakfastMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentBreakfastMenuBinding = fragmentBreakfastMenuBinding.inflate(inflater, container, false);
        return fragmentBreakfastMenuBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        breakfastMenuListAdapter = new BreakfastMenuListAdapter();
        fragmentBreakfastMenuBinding.BreakfastMenuRecycleView.setAdapter(breakfastMenuListAdapter);

        breakfastMenuModel = new ViewModelProvider(requireActivity()).get(BreakfastMenuModel.class);
        breakfastMenuModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                breakfastMenuListAdapter.submitList(products);
            }
        });
    }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {

    }
}