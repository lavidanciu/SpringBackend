package com.backend.backend.Service;

import com.backend.backend.Model.AppUser;
import com.backend.backend.Model.Products;

import java.util.List;

public interface AccountService {
    public AppUser registerUser(AppUser appUser);

    Products UpdateProduct(Products product);

    public List<AppUser> getAllUsers();

    public AppUser getUserByUsername(String username);
    public  boolean loginValidation (String username,String password);

    List<Products> getAllProducts();

    public Products getProductsByName(String name);
    public Products getProductsByDescription(String description);





}
