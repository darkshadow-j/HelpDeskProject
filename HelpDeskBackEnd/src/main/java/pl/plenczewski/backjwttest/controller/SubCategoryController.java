package pl.plenczewski.backjwttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.plenczewski.backjwttest.models.ticket.Category;
import pl.plenczewski.backjwttest.models.ticket.Subcategory;
import pl.plenczewski.backjwttest.services.categories.SubCategoriesService;

@RestController
@CrossOrigin
@RequestMapping("/subcategory")
public class SubCategoryController {

    private SubCategoriesService subCategoriesService;

    @Autowired
    public SubCategoryController(SubCategoriesService subCategoriesService) {
        this.subCategoriesService = subCategoriesService;
    }

    @PutMapping
    public ResponseEntity<Category> addNewSubCategory(@RequestBody Subcategory subcategory, @RequestParam Long categoryID){
        return new ResponseEntity<>(subCategoriesService.addNewSubCategory(subcategory, categoryID), HttpStatus.OK);
    }

}
