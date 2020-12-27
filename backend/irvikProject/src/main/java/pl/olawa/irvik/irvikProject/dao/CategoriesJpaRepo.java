package pl.olawa.irvik.irvikProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.olawa.irvik.irvikProject.domain.Categories;

public interface CategoriesJpaRepo extends JpaRepository<Categories,Long> {


}
