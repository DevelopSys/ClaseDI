import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProfesoresService {
  urlBase = 'https://randomuser.me/api/?results=';
  retorno: [] = [];

  constructor(private servicioHttp: HttpClient) {}

  getAllProfesores(): Observable<any> {
    return this.servicioHttp.get(`${this.urlBase}` + 500);
  }

  getProfesoresResults(numero: number): Observable<any> {
    return this.servicioHttp.get(`${this.urlBase}` + numero);
  }
}
