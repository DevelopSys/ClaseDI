import { Injectable } from '@angular/core';
import { asignatura } from '../model/asignatura';

@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {

  private asignaturas: asignatura[] = [
    {
      nombre: 'Programacion',
      siglas: 'PRO',
      horas: 8,
      profesor: 'Borja Martin Herrera',
      curso: 'DAM|DAW',
      nivel: 1,
      conocimientos: ['Java', 'MySQL', 'Algoritmos', 'Ficheros'],
      imagen: '',
    },
    {
      nombre: 'Sistemas',
      siglas: 'SI',
      horas: 6,
      profesor: 'Luis Miguel Serrano',
      curso: 'DAM|DAW',
      nivel: 1,
      conocimientos: ['Windows', 'Linux', 'Bash', 'Powershell'],
      imagen: '',
    },
    {
      nombre: 'Programacion multimedia',
      siglas: 'PMDM',
      horas: 5,
      profesor: 'Borja Martin Herrera',
      curso: 'DAM',
      nivel: 2,
      conocimientos: ['Java', 'Kotlin', 'Firebase', 'XML'],
      imagen:
        'https://sm.pcmag.com/pcmag_au/review/g/google-and/google-android-11_egj3.png',
    },
    {
      nombre: 'Desarrollo Interfaces',
      siglas: 'DI',
      horas: 5,
      profesor: 'Borja Martin Herrera',
      curso: 'DAM',
      nivel: 2,
      conocimientos: ['Java', 'JavaFX', 'JS', 'Angular'],
      imagen:
        'https://malcoded.com/static/3cc4cb18747975e37af4cc86dbd62ed3/f3583/angular-i18n.png',
    },
    {
      nombre: 'Ingles',
      siglas: 'ING',
      horas: 2,
      profesor: 'Rocio Pizarro',
      curso: 'DAM|DAW',
      nivel: 2,
      conocimientos: ['Ingles', 'tecnologia', 'vocabulario'],
      imagen:
        'https://img.freepik.com/vector-gratis/fondo-libro-ingles-dibujado-mano_23-2149483338.jpg',
    },
  ]

  constructor(){

  }

  getAllAsignaturas() : asignatura[] {
    return this.asignaturas;
  }

  getProfesorAsignaturas(nombre: string): asignatura[]{

  }

  getConocomientoAsignaturas(conocimiento: string): asignatura[]{

  }

  getCursoAsignaturas(curso: string): asignatura[]{

  }
 
}
