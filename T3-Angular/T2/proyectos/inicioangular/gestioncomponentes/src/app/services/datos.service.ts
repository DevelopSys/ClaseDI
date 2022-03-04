import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DatosService {

  arrayUno: string[] = ["Uno","Dos","Tres","Cuatro","Cinco"]
  arrayDos: string[] = ["Seis","Siete","Ocho","Nueve","Diez"]

  constructor() { }

  getArrayUno(): string[] {
    return this.arrayUno;
  }
  getArrayDos(): string[] {
    return this.arrayDos;
  }
}
