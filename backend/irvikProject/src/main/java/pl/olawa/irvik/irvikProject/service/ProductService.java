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

@Service
public class ProductService implements ProductServiceImpl {



    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductsCrudRepo productsCrudRepo;


    private List<Products> products;


    @Override
    public Products save(Products products) {
       return productsCrudRepo.save(products);
    }

    @Override
    public void delete(long id) {
        Products  products = productsCrudRepo.findById(id).orElseThrow(()-> new ProductnotFoundException("products not exist with id :" + id));
        productsCrudRepo.delete(products);
    }
    @Override
    public ResponseEntity<Products> update(Long id, ProductsDto productsDto) {
        Products products = productRepository.findById(id).orElseThrow(()-> new ProductnotFoundException("products not exist with id :" + id));
        products.setTitle(productsDto.getTitle());
        products.setDescription(productsDto.getDescription());
        products.setMaterial(productsDto.getMaterial());
        products.setCategory(productsDto.getCategory());
        products.setDiscount(productsDto.getDiscount());
        products.setTotalPrice(productsDto.getTotalPrice());
        products.setAvailable(productsDto.isAvailable());
        products.setWidth(productsDto.getWidth());
        products.setLength(productsDto.getLength());
        products.setHeight(productsDto.getHeight());
        Products productsEmp = productRepository.save(products);
        return  ResponseEntity.ok(productsEmp);

    }


//    @Override
//    public Products findById(long id) {
//
//        return productRepository.getOne(id);
//    }


    @Override
    public List<Products> findByTitle(String title) {
        return productRepository.findByMaterial(title);
    }

    @Override
    public Products findById(long productId) {
       return productRepository.findById(productId);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public List<Products> findByMaterial(String material) {
        return productRepository.findByMaterial(material);
    }

    @Override
    public List<Products> findByCategory(String category) {
        return productRepository.findByCategory(category);
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
