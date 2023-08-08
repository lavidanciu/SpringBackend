package com.backend.backend.Model;

import javax.persistence.*;

@Entity
@Table (name = "products")
public class Products {
    private int price;
    private String category;
    private String description;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private Integer quantity;

    @Id
    //genereaza automat id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduct;

    @Column(unique = true)
    private String name;
    private String image;


    public Products() {

    }

    public Products(int price, String category, String description, Integer idProduct, String name, String image,Integer quantity) {
        this.price = price;
        this.category = category;
        this.description = description;
        this.idProduct = idProduct;
        this.name = name;
        this.image = image;
        this.quantity=quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageURL) {
        this.image = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
