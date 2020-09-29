import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


const API_URL = 'http://46.41.138.231:8080/file/';

@Injectable({
  providedIn: 'root'
})
export class FileuploadService {

  constructor(private http: HttpClient) {}
  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;


  uploadFile( file: File[] , id : number ) : Observable<any>
  {
    let url = API_URL + id ;
    const formdata: FormData = new FormData();

    file.forEach(value => {
      formdata.append('file', value);
    });

    return this.http.post(url , formdata);
  }

  getImage(id: any) : Observable<File[]> {
    let url = API_URL + id ;
    return this.http.get<File[]>(url);
  }
}
