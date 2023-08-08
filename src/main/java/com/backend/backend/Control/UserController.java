package com.backend.backend.Control;

import com.backend.backend.Model.AppUser;
import com.backend.backend.Model.Products;
import com.backend.backend.Service.AccountService;

import com.backend.backend.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUser user) {

        return accountService.registerUser(user);
    }

    @GetMapping("/users")
    public List<AppUser> getUsers() {
        return accountService.getAllUsers();

    }
  ///functie care

    @PostMapping("/login")
    //@PathVariabile asteapta un parametru username din formul de angular ,anaglog pt parola
    public AppUser getUser(@RequestBody LoginUser user) {
        boolean flag = false;//la inceput variabila este falsa deoarece nu stim daca clientul exista in baza de date
        // AppUser userFormDatabase = null;
        flag = accountService.loginValidation(user.getUsername(), user.getPassword());//functia care returneaza un user daca este gasit in baza de date
        AppUser userFormDatabase=null;
        if (flag == true) userFormDatabase = accountService.getUserByUsername(user.getUsername());//daca flag=true am gasit clientul in baza de date
        return userFormDatabase;//returnez user
    }

    @PostMapping("/items")
    public void getProduct(@RequestBody Products[] product) {
        Products productSelected=null;
        for(Products i:product)
        {
            productSelected=accountService.getProductsByName(i.getName());
            if(productSelected.getQuantity()>0) {
                productSelected.setQuantity(productSelected.getQuantity() - 1);
                accountService.UpdateProduct(productSelected);
            }
        }
    }
    @PostMapping("/forgot")
    public void changePass(@RequestBody LoginUser user) {
        AppUser userFormDatabase=null;
        userFormDatabase=accountService.getUserByUsername(user.getUsername());
        if(user!=null)
        {
            user.setPassword(user.getPassword());
            accountService.registerUser(userFormDatabase);
        }
    }

    @GetMapping("/products")
    public List<Products> getProducts(){
        return accountService.getAllProducts();
    }

}
