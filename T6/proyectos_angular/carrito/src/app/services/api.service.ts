import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private api: HttpClient) {}

  getAllProducts(): Observable<any> {
    return this.api.get(
      'https://run.mocky.io/v3/22cb1828-bd62-4146-8b8c-6389c8119f1c'
    );
  }
}
