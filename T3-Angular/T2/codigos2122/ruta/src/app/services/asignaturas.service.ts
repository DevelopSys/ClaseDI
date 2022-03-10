import { Injectable } from '@angular/core';
import { asignatura } from '../utils/asignatura';

@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {
  // gestionar todos los datos

  asignaturas: asignatura[] = [
    {
      asignatura: 'Programacion multimedia',
      siglas: 'PMDM',
      horas: 4,
      profesor: 'Borja Martin',
      ciclo: 'DAM',
      curso: 2,
      conocimientos: ['Java', 'XML', 'JSON', 'Android'],
      imagen:
        'https://media.kasperskydaily.com/wp-content/uploads/sites/88/2019/12/09182151/android-device-identifiers-featured.jpg',
    },
    {
      asignatura: 'Desarrollo interfaces',
      siglas: 'DI',
      horas: 6,
      profesor: 'Borja Martin',
      ciclo: 'DAM',
      curso: 2,
      conocimientos: ['Java', 'JavaScript', 'Typescript', 'JSON'],
      imagen:
        'https://entreunosyceros.net/wp-content/uploads/2013/11/interface-usuario.png',
    },
    {
      asignatura: 'Sistemas informaticos',
      siglas: 'SI',
      horas: 6,
      profesor: 'Alfonso',
      ciclo: 'DAM|DAW',
      curso: 1,
      conocimientos: ['Sistemas', 'Hardware', 'Servidores', 'SO'],
      imagen:
        'https://concepto.de/wp-content/uploads/2018/08/software-de-sistema-1-e1534948748523.jpg',
    },
    {
      asignatura: 'Base de datos',
      siglas: 'BD',
      horas: 6,
      profesor: 'Fernando Sanchez',
      ciclo: 'DAM|DAW',
      curso: 1,
      conocimientos: ['Base dato', 'MySQL', 'Oracle'],
      imagen:
        'https://bookdown.org/paranedagarcia/database/images/database.jpg',
    },
    {
      asignatura: 'Desarrollo cliente',
      siglas: 'DC',
      horas: 6,
      profesor: 'Borja Martin',
      ciclo: 'DAW',
      curso: 2,
      conocimientos: ['JavaScript', 'React', 'NODE'],
      imagen: '',
    },
    {
      asignatura: 'Desarrollo servidor',
      siglas: 'DW',
      horas: 6,
      profesor: 'Borja Martin',
      ciclo: 'DAW',
      curso: 2,
      conocimientos: ['PHP', 'Django'],
      imagen: '',
    },
  ];
  constructor() {}

  fitrarAsignaturas(curso: string): asignatura[] {
    // obtengo un [] de las asignaturas que cumplen la condicion
    return this.asignaturas.filter((e) => {
      return e.ciclo.toLowerCase().includes(curso.toLowerCase());
    });
  }

  filtrarCompleto(curso: string, ciclo: string): asignatura[] {
    return this.asignaturas.filter((e) => {
      return e.ciclo.toLowerCase().includes(curso) && e.curso == Number(ciclo);
    });
  }
}
