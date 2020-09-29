import {Component, OnInit, TemplateRef} from '@angular/core';
import {CategoryService} from '../../_services/category.service';
import {Category, SubCategory} from '../../_services/ticket.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Message} from '../../_services/message.service';
import {SubcategoryService} from '../../_services/subcategory.service';


@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {

  categories: Category[];
  selectedCategory: Category;

  constructor(private modalService: NgbModal, private categoryService: CategoryService, private subCategory: SubcategoryService) {
  }

  ngOnInit(): void {
    this.categoryService.getAllTicket().subscribe(value => {
      this.categories = value;
    });
  }

  addNewSubCategory(category: Category) {
    console.log(category.id);
  }

  openModalNewSubcategory(addNewSubCategory: TemplateRef<any>, category: Category) {
    console.log('SSS');
    this.selectedCategory = category;
    this.modalService.open(addNewSubCategory);
  }

  closeModals() {
    this.modalService.dismissAll();
  }

  newSubCategorySubmit(value: string) {
    const newSubCat: SubCategory = ({
      subcategoryName: value
    });
    this.subCategory.addNewSubCategory(newSubCat, this.selectedCategory.id).subscribe(value1 => {
      this.categories.forEach(value2 => {
        if (value2.id = value1.id) {
          value2.subcategories = value1.subcategories;
          this.closeModals();
        }
      });
    });
  }

  openModalNewCategory(addNewCategory: TemplateRef<any>) {
    console.log('sss');
    this.modalService.open(addNewCategory);
  }

  newCategorySubmit(value: string) {
    const newCategory: Category = ({
      categoryName: value
    });
    this.categoryService.addNewCategory(newCategory).subscribe(value1 => {
      console.log('DONE');
    });
  }
}
