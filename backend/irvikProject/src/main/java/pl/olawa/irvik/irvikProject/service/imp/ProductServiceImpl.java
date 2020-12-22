package pl.olawa.irvik.irvikProject.service.imp;

import org.springframework.http.ResponseEntity;
import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;

import java.util.List;
import java.util.Optional;

public interface ProductServiceImpl {


    public Products save(Products products);

    void delete(long id);

    ResponseEntity<Products> update(Long id, ProductsDto products);

    Products findById(long productId);

    List<Products> getAllProducts();

    List<Products> findByTitle(String title);

    List<Products> findByMaterial(String material);

    List<Products> findByCategory(String category);

    List<Products> findByTotalPrice(int totalPrice);

    List<Products> findByIsAvailable(boolean isAvailable);

    List<Products> findByWidth(int width);

    List<Products> findByLength(int length);

    List<Products> findByHeight(int height);

    List<Products>findByWidthAndByLengthAndheight(int width,int length,int height);
}
