package pl.olawa.irvik.irvikProject.dto;

import org.springframework.web.multipart.MultipartFile;
import pl.olawa.irvik.irvikProject.domain.Products;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;

public class ProductsDTOHelper {


    public static Products createProducts(Products products,MultipartFile file) throws IOException {

        products.setImages(Collections.singletonList(Base64.getEncoder().encodeToString(file.getBytes())));

        return products;
    }

}
