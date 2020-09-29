import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Message} from './message.service';
import {Category, SubCategory} from './ticket.service';

const API_URL = 'http://46.41.138.231:8080/subcategory';

@Injectable({
  providedIn: 'root'
})
export class SubcategoryService {

  constructor(private http: HttpClient) { }

  addNewSubCategory(subCategory: SubCategory, categoryID: any): Observable<Category> {
    const params = new HttpParams()
      .set('categoryID', categoryID);
    return this.http.put<Category>(API_URL, subCategory, { params });
  }
}
