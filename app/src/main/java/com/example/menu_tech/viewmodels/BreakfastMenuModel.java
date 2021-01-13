package com.example.menu_tech.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.menu_tech.models.Product;
import com.example.menu_tech.repositories.BreakfastMenuRepo;

import java.util.List;

public class BreakfastMenuModel extends ViewModel {

    BreakfastMenuRepo breakfastMenuRepo = new BreakfastMenuRepo();

    public LiveData<List<Product>> getProducts() {

        return breakfastMenuRepo.getProducts();
    }
}
