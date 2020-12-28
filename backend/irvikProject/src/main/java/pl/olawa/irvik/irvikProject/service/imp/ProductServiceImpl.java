package pl.olawa.irvik.irvikProject.service.imp;

import org.springframework.http.ResponseEntity;
import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductServiceImpl {


    public Products save(Products products);

    void delete(UUID id);

    ResponseEntity<Products> update(UUID id, ProductsDto products);

    Optional<Products> findById(UUID productId);

    List<Products> getMaterialEu(String materialEu);

    List<Products> getMaterialPl(String materialPl);

    List<Products> getMaterialUk(String materialUk);


    List<Products> findByTitleUk(String titleUk);
    List<Products> findByTitleEn(String titleEn);
    List<Products> findByTitlePl(String titlePl);

    List<Products> getAllProducts();

    List<Products> findByTotalPrice(int totalPrice);

    List<Products> findByIsAvailable(boolean isAvailable);

    List<Products> findByWidth(int width);

    List<Products> findByLength(int length);

    List<Products> findByHeight(int height);

    List<Products>findByWidthAndByLengthAndheight(int width,int length,int height);
}
