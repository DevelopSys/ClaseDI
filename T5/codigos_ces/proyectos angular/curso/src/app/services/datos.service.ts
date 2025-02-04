import { Injectable } from '@angular/core';
import { Curso } from '../model/curso';

@Injectable({
  providedIn: 'root',
})
export class DatosService {
  private cursos: Curso[] = [
    {
      id: 1,
      familia: 'Informatica',
      nivel: 1,
      nombre: 'Desarrollo Aplicaciones Multiplataforma',
      asignaturas: [
        {
          id: 1,
          curso: '1',
          nombre: 'Programacion multimedia',
          siglas: 'PMDM',
          horas: 6,
          profesor: 'Borja',
          conocimientos: ['Kotlin', 'XML'],
        },
        {
          id: 2,
          curso: '1',
          nombre: 'Desarrollo interfaces',
          siglas: 'DI',
          horas: 6,
          profesor: 'Borja',
          conocimientos: ['Java', 'Javascript'],
        },
      ],
    },
    {
      id: 1,
      familia: 'Informatica',
      nivel: 1,
      nombre: 'Administracion de Sistemas en Red',
      asignaturas: [
        {
          id: 1,
          curso: '1',
          nombre: 'Programacion multimedia',
          siglas: 'PMDM',
          horas: 6,
          profesor: 'Borja',
          conocimientos: ['Kotlin', 'XML'],
        },
        {
          id: 2,
          curso: '1',
          nombre: 'Desarrollo interfaces',
          siglas: 'DI',
          horas: 6,
          profesor: 'Borja',
          conocimientos: ['Java', 'Javascript'],
        },
      ],
    },
    {
      id: 2,
      familia: 'Informatica',
      nivel: 1,
      nombre: 'Desarrollo Aplicaciones Web',
      asignaturas: [
        {
          id: 1,
          curso: '1',
          nombre: 'Programacion multimedia',
          siglas: 'PMDM',
          horas: 6,
          profesor: 'Borja',
          conocimientos: ['Kotlin', 'XML'],
        },
        {
          id: 2,
          curso: '1',
          nombre: 'Desarrollo interfaces',
          siglas: 'DI',
          horas: 6,
          profesor: 'Borja',
          conocimientos: ['Java', 'Javascript'],
        },
      ],
    },

    /*     id: number;
    nombre: string;
    siglas: string;
    profesor: string;
    horas: number;
    conocimientos: string[];
    curso: string; */
  ];

  constructor() {}

  // todas las funcionalidades que me interesa gestionar con los datos

  getAllCursosByFamilia(familia: string): Curso[] {
    return this.cursos.filter((item) => item.familia == familia);
  }

  getAllCursos(): Curso[] {
    return this.cursos;
  }
}
