package pl.olawa.irvik.irvikProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.olawa.irvik.irvikProject.domain.Products;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Products, UUID>, JpaSpecificationExecutor<Products> {

    Optional<Products> findById(UUID id);


    List<Products> findByTotalPrice(int totalPrice);

    List<Products> findByIsAvailable(boolean isAvailable);

    List<Products> findByWidth(int width);

    List<Products> findByLength(int length);

    List<Products> findByHeight(int height);

    List<Products> findByWidthAndLengthAndHeight(int width,int length,int height);



    List<Products> findByMaterialEn(String materialEn);

    List<Products> findByMaterialPl(String materialPl);

    List<Products> findByMaterialUk(String materialUk);


    List<Products> findByTitleUk(String titleUk);
    List<Products> findByTitleEn(String titleEn);
    List<Products> findByTitlePl(String titlePl);

}
