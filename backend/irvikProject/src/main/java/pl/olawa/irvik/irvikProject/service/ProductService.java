package pl.olawa.irvik.irvikProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.olawa.irvik.irvikProject.dao.ProductRepository;
import pl.olawa.irvik.irvikProject.dao.ProductsCrudRepo;
import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;
import pl.olawa.irvik.irvikProject.exception.ProductnotFoundException;
import pl.olawa.irvik.irvikProject.service.imp.ProductServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductsCrudRepo productsCrudRepo;

    @Override
    public Products save(Products products) {
       return productsCrudRepo.save(products);
    }


    @Override
    public void delete(UUID id) {
        Products  products = productsCrudRepo.findById(id).orElseThrow(()-> new ProductnotFoundException("products not exist with id :" + id));
        productsCrudRepo.delete(products);
    }
    @Override
    public ResponseEntity<Products> update(UUID id, ProductsDto productsDto) {
        Products products = productRepository.findById(id).orElseThrow(()-> new ProductnotFoundException("products not exist with id :" + id));
        products.setMaterialEn(productsDto.getMaterialEn());
        products.setMaterialPl(productsDto.getMaterialPl());
        products.setMaterialUk(productsDto.getMaterialUk());
        products.setTitleEn(productsDto.getTitleEn());
        products.setTitlePl(productsDto.getTitlePl());
        products.setTitleUk(productsDto.getTitleUk());
        products.setDescriptionEn(productsDto.getDescriptionEn());
        products.setDescriptionPl(productsDto.getDescriptionPl());
        products.setDescriptionUk(productsDto.getDescriptionUk());
        products.setCategory(productsDto.getCategory());
        products.setDiscount(productsDto.getDiscount());
        products.setTotalPrice(productsDto.getTotalPrice());
        products.setAvailable(productsDto.isAvailable());
        products.setWidth(productsDto.getWidth());
        products.setLength(productsDto.getLength());
        products.setHeight(productsDto.getHeight());
        products.setImages(productsDto.getImages());
        Products productsEmp = productRepository.save(products);
        return  ResponseEntity.ok(productsEmp);

    }


//    @Override
//    public Products findById(long id) {
//
//        return productRepository.getOne(id);
//    }




    @Override
    public Optional<Products> findById(UUID productId) {
       return productRepository.findById(productId);
    }

    @Override
    public List<Products> getMaterialEu(String materialEu) {
        return productRepository.findByMaterialEn(materialEu);
    }

    @Override
    public List<Products> getMaterialPl(String materialPl) {
        return productRepository.findByMaterialPl(materialPl);
    }

    @Override
    public List<Products> getMaterialUk(String materialUk) {
        return productRepository.findByMaterialUk(materialUk);
    }

    @Override
    public List<Products> findByTitleUk(String titleUk) {
        return productRepository.findByMaterialUk(titleUk);
    }

    @Override
    public List<Products> findByTitleEn(String titleEn) {
        return productRepository.findByMaterialEn(titleEn);
    }

    @Override
    public List<Products> findByTitlePl(String titlePl) {
        return productRepository.findByMaterialPl(titlePl);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Products> findByTotalPrice(int totalPrice) {
        return productRepository.findByTotalPrice(totalPrice);
    }


    @Override
    public List<Products> findByIsAvailable(boolean isAvailable) {
        if(isAvailable== false){
            throw new ProductnotFoundException("\n" +
                    "not available ");

        }
        return productRepository.findByIsAvailable(isAvailable);

        }

    @Override
    public List<Products> findByWidth(int width) {
        return productRepository.findByWidth(width);
    }

    @Override
    public List<Products> findByLength(int length) {
        return productRepository.findByLength(length);
    }

    @Override
    public List<Products> findByHeight(int height) {
        return productRepository.findByHeight(height);
    }

    @Override
    public List<Products> findByWidthAndByLengthAndheight(int width, int length, int height) {
        return productRepository.findByWidthAndLengthAndHeight(width,length,height);
    }


    //exception

}
