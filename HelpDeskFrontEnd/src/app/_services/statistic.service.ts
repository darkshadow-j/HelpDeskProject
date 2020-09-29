import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatisticService {

  constructor(private http: HttpClient) {
  }

  getStatistics(): Observable<Statistic[]>{
    return this.http.get<Statistic[]>('http://46.41.138.231:8080/statistic');
  }

}


export interface SubCategoryList {
  id: number;
  subcategoryName: string;
}

export interface SubCategoryWithColor {
  id: number;
  subCategoryList: SubCategoryList;
  color: string;
  value: number;
}

export interface Statistic {
  id: number;
  nameStatistic: string;
  subCategoryWithColor: SubCategoryWithColor[];
}



