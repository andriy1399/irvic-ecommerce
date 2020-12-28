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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.olawa.irvik.irvikProject.dao.ProductRepository;
import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;
import pl.olawa.irvik.irvikProject.exception.ProductnotFoundException;
import pl.olawa.irvik.irvikProject.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class ProductsController {
    @Autowired
    private ProductService productService;

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
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

    @PostMapping("/products")
    public Products addProducts(@RequestBody Products products){
    return  productService.save(products);
    }

    @PutMapping("/admin/products/{id}")
    public void updateProducts(@PathVariable("id") UUID id, @RequestBody ProductsDto products){
         productService.update(id,products);
    }


    @DeleteMapping("/admin/products/{id}")
    void deleteById(@PathVariable UUID id){

       productService.delete(id);
    }

    //get method
    @GetMapping("/productById/{id}")
    public Optional<Products> findById(@PathVariable("id") UUID id) throws ProductnotFoundException {
        return  productService.findById(id);
    }

//    @GetMapping("/productsCategory/{category}")
//    public List<Products> findByCategory(@PathVariable String category){
//        return  productService.findByCategory(category);

    @GetMapping("/productsAvailable/{available}")
    public List<Products> findByAvailable(@PathVariable Boolean available){
        return  productService.findByIsAvailable(available);
    }
    @GetMapping("/productmaterialEn/{materialEu}")
    public List<Products> findbyMaterialEu(@PathVariable("materialEu") String  materialEu){
        return productService.getMaterialEu(materialEu);
    }
    @GetMapping("/productmaterialPl/{materialPl}")
    public List<Products> findbyMaterialPl(@PathVariable("materialPl") String  materialPl){
        return productService.getMaterialPl(materialPl);
    }
    @GetMapping("/productmaterialUk/{materialUk}")
    public List<Products> findbyMaterialUk(@PathVariable("materialUk") String  materialUk){
        return productService.getMaterialUk(materialUk);
    }
    @GetMapping("/producttitlelUk/{titlelUk}")
    public List<Products> findbyTitlelUk(@PathVariable("titlelUk") String  titleUk){
        return productService.findByTitleUk(titleUk);
    }
    @GetMapping("/producttitleEn{titleEn}")
    public List<Products> findbyTitlelEn(@PathVariable("titleEn") String  titleEn){
        return productService.findByTitleEn(titleEn);
    }
    @GetMapping("/producttitlelUk/{titlelPl}")
    public List<Products> findbyTitlelPl(@PathVariable("titlelPl") String  titlePl){
        return productService.findByTitlePl(titlePl);
    }
//
}
