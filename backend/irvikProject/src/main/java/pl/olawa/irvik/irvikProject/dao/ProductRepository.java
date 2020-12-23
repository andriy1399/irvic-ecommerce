package pl.olawa.irvik.irvikProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.olawa.irvik.irvikProject.domain.Products;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long>, JpaSpecificationExecutor<Products> {

        Products findById(long id);
    List<Products> findByMaterial(String material);

    List<Products> findByCategory(String category);

    List<Products> findByTotalPrice(int totalPrice);

    List<Products> findByIsAvailable(boolean isAvailable);


    List<Products> findByWidth(int width);

    List<Products> findByLength(int length);

    List<Products> findByHeight(int height);

    List<Products> findByWidthAndLengthAndHeight(int width,int length,int height);

}
