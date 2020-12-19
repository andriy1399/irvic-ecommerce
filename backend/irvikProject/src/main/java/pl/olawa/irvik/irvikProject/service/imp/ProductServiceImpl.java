package pl.olawa.irvik.irvikProject.service.imp;

import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;

import java.util.List;

public interface ProductServiceImpl {


    void save(Products products);

    void deleteById(Long id);

    void update(Long id,ProductsDto products);


    List<Products> findByTitle(String title);

    void findById(Long id);

    List<Products> findByMaterial(String material);

    List<Products> findByCategory(String category);

    List<Products> findByTotalPrice(int totalPrice);

    List<Products> findByIsAvailable(boolean isAvailable);

    List<Products> findByWidth(int width);

    List<Products> findByLength(int length);

    List<Products> findByHeight(int height);

    List<Products>findByWidthAndByLengthAndheight(int width,int length,int height);
}
