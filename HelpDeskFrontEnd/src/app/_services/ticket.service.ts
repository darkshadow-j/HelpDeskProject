import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Message} from './message.service';


const API_URL = 'http://46.41.138.231:8080/ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  constructor(private http: HttpClient) {
  }

  createNewTicket(ticket: Ticket): Observable<Ticket> {
    return this.http.put<Ticket>(API_URL, ticket);
  }

  getAllTickets(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(API_URL);
  }

  getTicketDetails(ide: any): Observable<Ticket> {
    const params = new HttpParams()
      .set('id', ide);
    return this.http.get<Ticket>(API_URL + '/details', {params});
  }

  updateTicket(ticket: Ticket): Observable<Ticket>{
    return this.http.post<Ticket>(API_URL, ticket);
  }

}


export interface Role {
  id: number;
  name: string;
}

export interface User {
  id: number;
  username?: string;
  imie?: string;
  email?: string;
  password?: string;
  roles?: Role[];
}

export interface Role2 {
  id: number;
  name: string;
}

export interface AssignedTo {
  id: number;
  username?: string;
  imie?: string;
  email?: string;
}

export interface Category {
  id?: number;
  categoryName: string;
  subcategories?: SubCategory[];
}

export interface SubCategory {
  id?: number;
  subcategoryName: string;
}

export interface Ticket {
  id?: number;
  topic?: string;
  user?: User;
  assignedTo?: AssignedTo;
  category?: Category;
  description?: string;
  ticketFlow?: string;
  ticketPriority?: string,
  message?: Message[];
  subcategory?: SubCategory;
/*  ticketAttachments?: TicketAttachment[];*/
}

export interface TicketAttachment {
  id?: number;
  attachment?: File;
  name: string;
}


