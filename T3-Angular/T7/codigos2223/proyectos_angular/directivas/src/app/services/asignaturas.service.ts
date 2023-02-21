import { Injectable } from '@angular/core';
import { Asignatura } from '../model/asignatura';

@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {
  // datos

  private asignaturas: Asignatura[] = [
    {
      nombre: 'Desarrollo cliente',
      siglas: 'DC',
      curso: 2,
      ciclo: 'DAW',
      imagen:
        'https://upload.wikimedia.org/wikipedia/commons/1/18/React_Native_Logo.png',
      profesor: 'Borja Martin',
      conocimientos: ['JS', 'Express', 'React'],
    },
    {
      nombre: 'Desarrollo servidor',
      siglas: 'DS',
      curso: 2,
      ciclo: 'DAW',
      imagen:
        'https://www.superprof.es/blog/wp-content/uploads/2019/04/imagen-en-php.jpg',
      profesor: 'David Ventura',
      conocimientos: ['PHP', 'Servicios', 'WebService'],
    },
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
      ciclo: 'DAM|DAW',
      imagen:
        'https://syltec.es/blog/wp-content/uploads/2021/10/Dise%C3%B1o-sin-t%C3%ADtulo-8-1024x512.jpg',
      profesor: 'Borja Martin',
      conocimientos: ['Java'],
    },
    {
      nombre: 'Base datos',
      siglas: 'BD',
      curso: 1,
      ciclo: 'DAM|DAW',
      imagen:
        'https://www.ymant.com/wp-content/uploads/Base-de-Datos-YMANT.jpg',
      profesor: 'Luis Hermida',
      conocimientos: ['MySQL', 'Mongo', 'SQL', 'NSQL'],
    },
  ];

  constructor() {}

  getAllAsignaturas(): Asignatura[] {
    this.asignaturas.filter((item) => {
      // retornar la condicion de busqueda
    }); // lista con todas las asignaturas que cumplan filtro de busqueda

    return this.asignaturas;
  }

  getAsignaturasFiltradas(numero: number): Asignatura[] {
    if (numero == 1 || numero == 2) {
      return this.asignaturas.filter(
        (item: Asignatura) => item.curso == numero
      );
    } else {
      return this.getAllAsignaturas();
    }
  }
}
