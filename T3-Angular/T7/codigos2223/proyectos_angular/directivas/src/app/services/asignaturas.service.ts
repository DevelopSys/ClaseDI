import { Injectable } from '@angular/core';
import { Asignatura } from '../model/asignatura';

@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {
  // datos

  private asignaturas: Asignatura[] = [
    {
      nombre: 'Programacion multimedia',
      siglas: 'PMDM',
      curso: 2,
      ciclo: 'DAM',
      imagen:
        'https://www.adslzone.net/app/uploads-adslzone.net/2019/12/android-malware-apps.jpg?x=480&y=375&quality=40',
      profesor: 'Borja Martin',
      conocimientos: ['Kotlin', 'xml', 'java'],
    },
    {
      nombre: 'Desarrollo de interfaces ',
      siglas: 'DI',
      curso: 2,
      ciclo: 'DAM',
      imagen:
        'https://www.ida.cl/wp-content/uploads/sites/5/2016/07/Disen%CC%83o-de-interfaces-a-la-medida-de-los-usuarios-v2.jpg',
      profesor: 'Borja Martin',
      conocimientos: ['Java', 'JS', 'Angular'],
    },
    {
      nombre: 'Programacion',
      siglas: 'PRO',
      curso: 1,
      ciclo: 'DAM',
      imagen:
        'https://syltec.es/blog/wp-content/uploads/2021/10/Dise%C3%B1o-sin-t%C3%ADtulo-8-1024x512.jpg',
      profesor: 'Borja Martin',
      conocimientos: ['Java'],
    },
    {
      nombre: 'Base datos',
      siglas: 'BD',
      curso: 1,
      ciclo: 'DAM',
      imagen:
        'https://www.ymant.com/wp-content/uploads/Base-de-Datos-YMANT.jpg',
      profesor: 'Luis Hermida',
      conocimientos: ['MySQL', 'Mongo', 'SQL', 'NSQL'],
    },
  ];

  constructor() {}

  getAllAsignaturas(): Asignatura[] {
    return this.asignaturas;
  }
}
