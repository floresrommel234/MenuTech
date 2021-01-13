package com.example.menu_tech.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu_tech.databinding.BreakfastmenuRowBinding;
import com.example.menu_tech.models.Product;

public class BreakfastMenuListAdapter extends ListAdapter<Product, BreakfastMenuListAdapter.BreakfastMenuViewHolder> {

    public BreakfastMenuListAdapter() {
        super(Product.itemCallback);
    }

    @NonNull
    @Override
    public BreakfastMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        BreakfastmenuRowBinding breakfastmenuRowBinding = BreakfastmenuRowBinding.inflate(layoutInflater, parent, false);
        return new BreakfastMenuViewHolder(breakfastmenuRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BreakfastMenuViewHolder holder, int position) {
        Product product = getItem(position);
        holder.breakfastmenuRowBinding.setProduct(product);

    }

    class BreakfastMenuViewHolder extends RecyclerView.ViewHolder {

        BreakfastmenuRowBinding breakfastmenuRowBinding;
        public BreakfastMenuViewHolder(BreakfastmenuRowBinding binding) {
            super(binding.getRoot());
            this.breakfastmenuRowBinding = binding;
        }
    }

    public interface BreakfastMenuInterface {
        void addItem(Product product);
        void onItemClick(Product product);
    }
}
