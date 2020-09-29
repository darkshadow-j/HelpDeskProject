package pl.plenczewski.backjwttest.services.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.plenczewski.backjwttest.models.ticket.Category;
import pl.plenczewski.backjwttest.models.ticket.Subcategory;
import pl.plenczewski.backjwttest.repository.CategoryRepository;
import pl.plenczewski.backjwttest.repository.SubCategoryRepository;

@Service
public class SubCategoriesService {
    private SubCategoryRepository subCategoryRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SubCategoriesService(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public Category addNewSubCategory(Subcategory subcategory, Long id){

        Category category = categoryRepository.findById(id).get();
        category.addNewSubCategory(subCategoryRepository.save(subcategory));
        return categoryRepository.save(category);
    }
}
