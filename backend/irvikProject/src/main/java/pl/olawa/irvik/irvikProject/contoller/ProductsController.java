package pl.olawa.irvik.irvikProject.contoller;


import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.olawa.irvik.irvikProject.dao.ProductRepository;
import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDTOHelper;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;
import pl.olawa.irvik.irvikProject.exception.ProductnotFoundException;
import pl.olawa.irvik.irvikProject.service.imp.ProductServiceIml;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class ProductsController {
    @Autowired
    private ProductServiceIml productService;

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//
    @PostMapping("/test/products")
    public Products addProducts_DeleTe(@RequestBody Products products, @ModelAttribute  MultipartFile image) throws IOException {
        return  productService.save(products,image);
    }

    //search Products
    @GetMapping("/productsfind")
    public ResponseEntity<List<Products>>searchForProducts(@SearchSpec Specification<Products> specification){
        return new ResponseEntity<>(productRepository.findAll(Specification.where(specification)), HttpStatus.OK);
    }

    //pagination
    @GetMapping("/allproducts")
    public Page<Products> getAllProducts(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        return productRepository.findAll(pageable);
    }
    //crud Operation
    @PutMapping("/test/products/{id}")
    public void updateProducts(@PathVariable("id") UUID id, @RequestBody ProductsDto products){
         productService.update(id,products);
    }


    @DeleteMapping("/test/products/{id}")
    void deleteById(@PathVariable("id") UUID id){
       productService.delete(id);
    }


    //get method
    @GetMapping("/products/{id}")
    public Optional<Products> findById(@PathVariable("id") UUID id) throws ProductnotFoundException {
        return  productService.findById(id);
    }

    @GetMapping("/products")
    public  List<Products> findall(){
        return  productRepository.findAll();
    }


    @GetMapping("/searchByfullText/{text}")
    public  List<Products> searchByFullTextName(@PathVariable("text") String text){
        return productService.searchByFullTextName(text);
    }

//
}
