package pl.plenczewski.backjwttest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.plenczewski.backjwttest.models.ticket.Category;
import pl.plenczewski.backjwttest.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {


    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category addNewCategory(Category category){
        return categoryRepository.save(category);
    }

}
