import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../model/interfeces';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  /* volley (org-json) httpConnection fetch(Promese - then/catch - await/async) httpClientModule(Observable) */
  constructor(private httpclient: HttpClient) {}

  getAllPost(): Observable<any> {
    return this.httpclient.get('https://dummyjson.com/posts');
  }
  getAllPostByTag(tag: string): Observable<any> {
    return this.httpclient.get(`https://dummyjson.com/posts/tag/${tag}`);
  }
}
