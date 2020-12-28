package pl.olawa.irvik.irvikProject.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.olawa.irvik.irvikProject.domain.Categories;
import pl.olawa.irvik.irvikProject.dto.CategoriesDto;
import pl.olawa.irvik.irvikProject.service.CategoriesService;
import pl.olawa.irvik.irvikProject.service.imp.CategoriesServiceImpl;

import java.util.UUID;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;

@RestController
@RequestMapping("/api/")
public class CategoriesController {

    @Autowired
    private CategoriesServiceImpl categoriesService;




   @PostMapping("/categories")
    public Categories addCategory(@RequestBody Categories categories){
       return  categoriesService.save(categories);
   }

   @PutMapping("/categories/{id}")
    public  void update(@PathVariable("id") java.util.UUID id, @RequestBody  CategoriesDto categoriesDto){
         categoriesService.update(id,categoriesDto);
   }
   @DeleteMapping("/categories/{id}")
    void  daleteById (@PathVariable("id") UUID id){
       categoriesService.delete(id);
   }


}
