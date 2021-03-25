package pl.olawa.irvik.irvikProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.olawa.irvik.irvikProject.domain.Categories;

import java.util.UUID;
@Repository
public interface CategoriesJpaRepo extends JpaRepository<Categories, UUID> {


}
