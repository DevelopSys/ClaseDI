import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tag } from '../model/modelos';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  // creo un array con los datos correspodientes

  constructor(private httpclient: HttpClient) {}

  // tantos metodos como consultas quiera hacer al API
  url = 'https://dummyjson.com/posts/';
  urlSearch = 'https://dummyjson.com/posts/search?q=';

  getAllTags(): Observable<any> {
    return this.httpclient.get('https://dummyjson.com/posts/tags');
  }

  /* getAllTagsPS(): Promise<any> {
    return fetch('https://dummyjson.com/posts/tags');

    // resolucion de la promesa en el componente que haga la llamad
    this.getAllTagsPS()
      .then((res) => res.json())
      .then((res1) => {});
  }
  async getAllTagsPSAW(): Promise<any> {
    let constestacion = await fetch('https://dummyjson.com/posts/tags');
    let respuesta = await constestacion.json();
    return respuesta;
  } */

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
