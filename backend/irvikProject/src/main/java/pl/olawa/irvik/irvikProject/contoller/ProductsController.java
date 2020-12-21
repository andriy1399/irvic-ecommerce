package pl.olawa.irvik.irvikProject.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.olawa.irvik.irvikProject.domain.Products;
import pl.olawa.irvik.irvikProject.dto.ProductsDto;
import pl.olawa.irvik.irvikProject.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductsController {
    @Autowired
    private ProductService productService;



    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return productService.getAllProducts();
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

//    @GetMapping("/productsById/{id}")
//    public Object findById(@PathVariable long id){
//        return  productService.findById(id);
//    }

}
