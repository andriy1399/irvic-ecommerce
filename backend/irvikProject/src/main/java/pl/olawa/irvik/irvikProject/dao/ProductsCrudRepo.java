package pl.olawa.irvik.irvikProject.dao;

import org.springframework.data.repository.CrudRepository;
import pl.olawa.irvik.irvikProject.domain.Products;

public interface ProductsCrudRepo extends CrudRepository<Products,Long> {

}
