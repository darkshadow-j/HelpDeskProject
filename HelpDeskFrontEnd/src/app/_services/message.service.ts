import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Ticket, User} from './ticket.service';
import {Observable} from 'rxjs';
import {isPackageNameSafeForAnalytics} from '@angular/cli/models/analytics';

const API_URL = 'http://46.41.138.231:8080/message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient) { }


    addNewMessageToTicket(message: Message, ticketId: any): Observable<Message> {
      const params = new HttpParams()
        .set('ticketID', ticketId);
    return this.http.put<Message>(API_URL, message, { params });
    }
}

export interface Message {
  id?: number;
  user: User;
  message: string;
}
