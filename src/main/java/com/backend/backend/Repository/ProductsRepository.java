package com.backend.backend.Repository;

import com.backend.backend.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    List<Products> findAll();
    Products getProductsByName(String name);
    Products getProductsByDescription(String description);

}
