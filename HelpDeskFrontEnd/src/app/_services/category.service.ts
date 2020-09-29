import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from './ticket.service';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {


  constructor(private http: HttpClient) {
  }

  public getAllTicket(): Observable<Category[]> {
    return this.http.get<Category[]>('http://46.41.138.231:8080/category');
  }

  public addNewCategory(category: Category): Observable<Category> {
    return this.http.put<Category>('http://46.41.138.231:8080/category', category);
  }

}
