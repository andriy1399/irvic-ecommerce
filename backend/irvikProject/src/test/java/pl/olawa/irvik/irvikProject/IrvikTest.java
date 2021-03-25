package pl.olawa.irvik.irvikProject;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.olawa.irvik.irvikProject.dao.CategoriesJpaRepo;
import pl.olawa.irvik.irvikProject.dao.CategoriesRepository;
import pl.olawa.irvik.irvikProject.domain.Categories;
import pl.olawa.irvik.irvikProject.service.CategoriesService;
import pl.olawa.irvik.irvikProject.service.imp.CategoriesServiceIml;

import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IrvikTest {

   @Autowired
    private CategoriesJpaRepo categoriesRepository;
    @Autowired
    private CategoriesServiceIml categoriesService;

    @Test
   public void categoriesAdd(){
        List<Categories> categories = (List<Categories>) categoriesRepository.findAll();
        assertThat(categories,hasSize(0));
        Categories categories1 = new Categories();
        categories1.setCategoryEn("asd");
        categories1.setCategoryPl("asd");
        categories1.setCategoryUk("asf");

        categoriesService.save(categories1);
        categories = (List<Categories>) categoriesRepository.findAll();
        assertThat(categories,hasSize(1));
    }


}
