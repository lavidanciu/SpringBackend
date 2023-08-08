package com.backend.backend.Service;

import com.backend.backend.Model.AppUser;
import com.backend.backend.Model.Products;
import com.backend.backend.Repository.AppUserRepository;
import com.backend.backend.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccounServiceImpl implements AccountService {

    @Autowired
    private  AppUserRepository appUserRepo;
    @Autowired
    private ProductsRepository productsRepo;;
    @Override
    public AppUser registerUser(AppUser appUser) {
       appUserRepo.save(appUser);
        return appUser;
    }
    @Override
    public Products UpdateProduct(Products product) {
        productsRepo.save(product);
        return product;
    }

    @Override
    public List<AppUser> getAllUsers() {

        return appUserRepo.findAll();
    }

    @Override
    public AppUser getUserByUsername(String username) {

       return  appUserRepo.findByUsername(username);
    }
    @Override
    public  boolean loginValidation (String username,String password)
    {
         AppUser user=appUserRepo.findByUsername(username);
         if(user!=null)
         {
             if(user.getPassword().equals(password)) return true;
             else return false;
         }
         return  false;
    }

    @Override
    public List<Products> getAllProducts(){
        return productsRepo.findAll();
    }

    @Override
    public Products getProductsByName(String name) {
        return productsRepo.getProductsByName(name);
    }

    @Override
    public Products getProductsByDescription(String description) {
        return productsRepo.getProductsByDescription(description);
    }




}
