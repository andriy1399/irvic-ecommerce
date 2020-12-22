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


    @GetMapping("/productById/{id}")
    public Object findById(@PathVariable long id){
        return  productService.findById(id);
    }

    @GetMapping("/productsMaterial/{material}")
    public List<Products> findByMaterial(@PathVariable String material){
      return  productService.findByMaterial(material);
    }
    @GetMapping("/productsCategory/{category}")
    public List<Products> findByCategory(@PathVariable String category){
        return  productService.findByCategory(category);
    }

    @GetMapping("/productsAvailable/{available}")
    public List<Products> findByAvailable(@PathVariable Boolean available){
        return  productService.findByIsAvailable(available);
    }
    @GetMapping("/productsWidth/{Width}")
    public List<Products> findByWidth(@PathVariable int width){
        return  productService.findByWidth(width);
    }
    @GetMapping("/productsLength/{length}")
    public List<Products> findBylength(@PathVariable int length){
        return  productService.findByLength(length);
    }

    @GetMapping("/productsHeight={height}")
    public List<Products> findByHeight(@PathVariable int height){
        return  productService.findByHeight(height);
    }

    @GetMapping("/findByWidthAndByLengthAndheight={width}&{length}&{height}")
    public List<Products> findByWidthAndByLengthAndheight(@PathVariable int width,@PathVariable int length,@PathVariable int height){
        return  productService.findByWidthAndByLengthAndheight(width,length,height);
    }

}
