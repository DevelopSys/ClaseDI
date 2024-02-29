import { Injectable } from '@angular/core';
import { Alumno } from '../model/alumno';
import { Asignatura } from '../model/curso';
import { Profesor } from '../model/profesor';

@Injectable({
  providedIn: 'root',
})
export class AcademiaService {
  /* Crear 12 asignaturas: 4 DAM, 4 DAW, 4 ASIR -> array*/
  /* PRO LM PMDM DI DWAC DWAS LM ISO ASO SI */
  /* Crear 4 profesores -> array */
  /* Crear 0 alumnos -> array */

  private alumnos: Alumno[] = [];
  private profesores: Profesor[] = [];
  private asignaturas: Asignatura[] = [];

  constructor() {
    /* inicializarlos */
    this.asignaturas = [
      {
        id: 1,
        nombre: 'Programacion',
        siglas: 'PRO',
        horas: 8,
        conocimientos: ['Java', 'Algoritmos'],
        ciclo: 'DAM|DAW',
        nivel: 1,
        profesor: null,
        imagen: 'https://dungeonofbits.com/images/java-logo.png',
      },
      {
        id: 2,
        nombre: 'Lenguaje de Marcas',
        siglas: 'LM',
        horas: 5,
        conocimientos: ['XML', 'HTML', 'JS'],
        ciclo: 'DAM|DAW|ASIR',
        nivel: 1,
        profesor: null,
        imagen:
          'https://www.startertutorials.com/ajwt/wp-content/uploads/2014/01/html1-2bk3qb4.jpg',
      },
      {
        id: 3,
        nombre: 'Programacion Multimedia',
        siglas: 'PMDM',
        horas: 6,
        conocimientos: ['Kotlin', 'XML', 'Firebase'],
        ciclo: 'DAM',
        nivel: 2,
        profesor: null,
        imagen:
          'https://storage.googleapis.com/gweb-uniblog-publish-prod/images/All-Up-Header-2880x1200_2.width-1200.format-webp.webp',
      },
      {
        id: 4,
        nombre: 'Desarrollo de interfaces',
        siglas: 'DI',
        horas: 6,
        conocimientos: ['JS', 'JavaFX', 'HTML', 'Angular'],
        ciclo: 'DAM',
        nivel: 2,
        profesor: null,
        imagen:
          'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROEZkhejt4PkW9qVOY6zzhaFwFh640j90PMw3k7M6Mt5tB-947O7qupI4fBR_AmAoUE30&usqp=CAU',
      },

      {
        id: 5,
        nombre: 'Desarrollo de aplicaciones entorno cliente',
        siglas: 'DAWC',
        horas: 6,
        conocimientos: ['JS', 'React', 'Vue'],
        ciclo: 'DAW',
        nivel: 2,
        profesor: null,
        imagen:
          'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROEZkhejt4PkW9qVOY6zzhaFwFh640j90PMw3k7M6Mt5tB-947O7qupI4fBR_AmAoUE30&usqp=CAU',
      },
      {
        id: 6,
        nombre: 'Desarrollo de aplicaciones entorno servidor',
        siglas: 'DAWS',
        horas: 6,
        conocimientos: ['PHP', 'Python', 'Symfony'],
        ciclo: 'DAW',
        nivel: 2,
        profesor: null,
        imagen:
          'https://codersfree.nyc3.cdn.digitaloceanspaces.com/posts/que-es-php-en-programacion-descubre-5-ventajas-de-usarlo.jpg',
      },
    ];
  }

  putAlumno(alumno: Alumno) {
    this.alumnos.push(alumno);
  }

  putAsignatura(asignatura: Asignatura) {
    this.asignaturas.push(asignatura);
  }

  getAllAsignaturas(): Asignatura[] {
    return this.asignaturas;
  }

  getAsignaturasCurso(curso: string): Asignatura[] {
    return this.asignaturas.filter((it: Asignatura) => {
      return it.ciclo.toLowerCase().includes(curso.toLowerCase());
    });
  }
}
