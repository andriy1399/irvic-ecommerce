package pl.olawa.irvik.irvikProject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.olawa.irvik.irvikProject.domain.Categories;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface CategoriesRepository extends CrudRepository<Categories,UUID> {


        Optional<Categories> findById(UUID id);

        void deleteById(UUID id);
}
