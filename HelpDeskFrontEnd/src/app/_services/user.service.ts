import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TokenStorageService} from './token-storage.service';

const API_URL = 'http://46.41.138.231:8080/api/test/';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService) {
  }


  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', {responseType: 'text'});
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', {responseType: 'text'});
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', {responseType: 'text'});
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', {responseType: 'text'});
  }

  getCurrentUser(): any {
    return this.tokenStorageService.getUser();
  }
}
