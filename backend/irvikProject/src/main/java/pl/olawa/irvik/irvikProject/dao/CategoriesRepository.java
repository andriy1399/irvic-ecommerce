package pl.olawa.irvik.irvikProject.dao;

import org.springframework.data.repository.CrudRepository;
import pl.olawa.irvik.irvikProject.domain.Categories;

public interface CategoriesRepository extends CrudRepository<Categories,Long> {
        Categories findById(long id);
}
