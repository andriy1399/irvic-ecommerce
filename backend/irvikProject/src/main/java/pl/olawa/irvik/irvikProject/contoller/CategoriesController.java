package pl.olawa.irvik.irvikProject.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.olawa.irvik.irvikProject.service.CategoriesService;
import pl.olawa.irvik.irvikProject.service.imp.CategoriesServiceImpl;

@RestController
@RequestMapping("/api/")
public class CategoriesController {

    @Autowired
    private CategoriesServiceImpl categoriesServic;


   // @PostMapping

}
