import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LigasService {
  urlLigas =
    'https://www.thesportsdb.com/api/v1/json/3/search_all_leagues.php?c=';

  constructor(private http: HttpClient) {}

  getAllLigas(pais: string): Observable<any> {
    this.urlLigas += pais;
    return this.http.get(this.urlLigas);
  }
}
