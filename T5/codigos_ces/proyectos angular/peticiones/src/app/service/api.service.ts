import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  // creo un array con los datos correspodientes

  constructor(private httpclient: HttpClient) {}

  // tantos metodos como consultas quiera hacer al API
  url = 'https://dummyjson.com/posts/';
  urlSearch = 'https://dummyjson.com/posts/search?q=';

  getAllPost(): Observable<any> {
    return this.httpclient.get(this.url);
  }

  /* getAllPost(): any {
    this.httpclient.get(this.url).subscribe((data) => {
      return data;
    });
  } */

  getPostById(id: number): Observable<any> {
    return this.httpclient.get(`${this.url}${id}`);
  }

  getPostSearch(query: string): Observable<any> {
    return this.httpclient.get(`${this.urlSearch}${query}`);
  }
}
