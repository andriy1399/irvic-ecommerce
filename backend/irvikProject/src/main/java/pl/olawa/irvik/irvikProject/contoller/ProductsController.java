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
import pl.olawa.irvik.irvikProject.dao.ProductRepository;
import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;
import pl.olawa.irvik.irvikProject.exception.ProductnotFoundException;
import pl.olawa.irvik.irvikProject.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductsController {
    @Autowired
    private ProductService productService;

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/productsfind")
    public ResponseEntity<List<Products>>searchForProducts(@SearchSpec Specification<Products> specification){
        return new ResponseEntity<>(productRepository.findAll(Specification.where(specification)), HttpStatus.OK);
    }


    @GetMapping("/allproducts")
    public Page<Products> getAllProducts(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        return productRepository.findAll(pageable);
    }
    //crud Operation

    @PostMapping("/products")
    public Products addProducts(@RequestBody Products products){
    return  productService.save(products);
    }

    @PutMapping("/products/{id}")
    public void updateProducts(@PathVariable Long id, @RequestBody ProductsDto products){
         productService.update(id,products);
    }


    @DeleteMapping("/products/{id}")
    void deleteById(@PathVariable long id){

       productService.delete(id);
    }


    @GetMapping("/productById/{id}")
    public Products findById(@PathVariable long id) throws ProductnotFoundException {

        return  productService.findById(id);
    }

    @GetMapping("/productsCategory/{category}")
    public List<Products> findByCategory(@PathVariable String category){
        return  productService.findByCategory(category);
    }

    @GetMapping("/productsAvailable/{available}")
    public List<Products> findByAvailable(@PathVariable Boolean available){
        return  productService.findByIsAvailable(available);
    }
//
}
