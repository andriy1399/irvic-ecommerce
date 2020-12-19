package pl.olawa.irvik.irvikProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.olawa.irvik.irvikProject.dao.ProductRepository;
import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;
import pl.olawa.irvik.irvikProject.exception.ResourcenotFoundException;
import pl.olawa.irvik.irvikProject.service.imp.ProductServiceImpl;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceImpl {



    @Autowired
    private ProductRepository productRepository;



    @Override
    public void save(Products products) {
        productRepository.save(products);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update( Long id, ProductsDto productsDto) {
        Products products = productRepository.findById(id).orElseThrow(()-> new ResourcenotFoundException("products not exist with id :" + id));
        products.setTitle(productsDto.getTitle());
        products.setDescription(productsDto.getDescription());
        products.setMaterial(productsDto.getMaterial());
        products.setCategory(productsDto.getCategory());
        products.setDiscount(productsDto.getDiscount());
        products.setTotalPrice(productsDto.getTotalPrice());
        products.setAvailable(productsDto.isAvailable());
        products.setWidth(productsDto.getWidth());
        products.setLength(productsDto.getLength());
        products.setLength(productsDto.getHeight());
        productRepository.save(products);

    }


    @Override
    public List<Products> findByTitle(String title) {
        return productRepository.findByMaterial(title);
    }

    @Override
    public void findById(Long id) {

        productRepository.findById(id);
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
    //add extheption
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


}
