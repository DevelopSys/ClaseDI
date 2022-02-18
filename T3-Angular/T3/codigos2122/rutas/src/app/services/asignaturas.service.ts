import { Injectable } from '@angular/core';
import { asignatura } from '../utils/asignatura';

@Injectable({
  providedIn: 'root'
})
export class AsignaturasService {

  asignaturas: asignatura[] = [
    { nombre: 'PMDM', profesor: 'BMH', hora: 5, curso: 'dam' },
    { nombre: 'DI', profesor: 'BMH', hora: 5, curso: 'dam' },
    { nombre: 'SI', profesor: 'IS', hora: 5, curso: 'dam|daw' },
    { nombre: 'BD', profesor: 'JG', hora: 5, curso: 'dam|daw' },
    { nombre: 'ED', profesor: 'JN', hora: 5, curso: 'dam|daw' },
    { nombre: 'PSP', profesor: 'JN', hora: 5, curso: 'dam' },
    { nombre: 'Ing', profesor: 'RP', hora: 5, curso: 'dam|daw' },
    { nombre: 'EIE', profesor: 'MV', hora: 5, curso: 'dam|daw' },
    { nombre: 'DAWC', profesor: 'BMH', hora: 5, curso: 'daw' },
    { nombre: 'DAWS', profesor: 'IS', hora: 5, curso: 'daw' },
    { nombre: 'DI', profesor: 'JG', hora: 5, curso: 'daw' },
    { nombre: 'DAW', profesor: 'JN', hora: 5, curso: 'daw' },
    { nombre: 'DP', profesor: 'BM', hora: 5, curso: 'bd' },
    { nombre: 'AD', profesor: 'DC', hora: 5, curso: 'bd' },
    { nombre: 'PD', profesor: 'AF', hora: 5, curso: 'bd' },
    { nombre: 'AWS', profesor: 'CA', hora: 5, curso: 'bd' },
  ];

  constructor() { }

  getAllAsignaturas(): asignatura[]{
      return this.asignaturas;
  }

  getAsignaturasFiltradas(filtro: string): asignatura[] {

    return this.asignaturas.filter((item)=>{return item.curso.toString().includes(filtro)})

  }


}
