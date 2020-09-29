package pl.plenczewski.backjwttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.plenczewski.backjwttest.models.ticket.Category;
import pl.plenczewski.backjwttest.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getAllCategory();
    }

    @PutMapping
    public ResponseEntity<Category> addNewCategory(@RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.addNewCategory(category), HttpStatus.OK);
    }

}
