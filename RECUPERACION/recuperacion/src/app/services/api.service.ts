import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private stringURL = 'https://restcountries.com/v3.1/all';

  private apiHttp = inject(HttpClient);

  constructor(private api: HttpClient) {}

  getAllCountries(): Observable<any> {
    return this.apiHttp.get(this.stringURL);
  }
}
