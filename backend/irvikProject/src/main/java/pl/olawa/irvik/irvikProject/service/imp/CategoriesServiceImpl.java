package pl.olawa.irvik.irvikProject.service.imp;

import org.springframework.http.ResponseEntity;
import pl.olawa.irvik.irvikProject.domain.Categories;
import pl.olawa.irvik.irvikProject.dto.CategoriesDto;

import java.util.List;

public interface CategoriesServiceImpl {

    public Categories save(Categories categories);

    public ResponseEntity<Categories> update(long id, CategoriesDto categoriesDto);

    public  Categories findById(long categoriesId);

    List<Categories> getAllCategories();

    void delete(long id);


}
