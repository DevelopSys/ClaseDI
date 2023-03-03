import { Component } from '@angular/core';
import { AsignaturaInterfaz } from 'src/app/model/asignatura_interfaz';

@Component({
  selector: 'app-asignaturas',
  templateUrl: './asignaturas.component.html',
  styleUrls: ['./asignaturas.component.css'],
})
export class AsignaturasComponent {
  asignturas: AsignaturaInterfaz[] = [
    {
      nombre: 'Progmacion Multimedia',
      siglas: 'PMDM',
      horas: 6,
      curso: 2,
      ciclo: 'DAM',
      imagen: '',
      conocimientos: ['Kotlin', 'Android', 'XML'],
    },
    {
      nombre: 'Desarrollo Interfaces',
      siglas: 'DI',
      horas: 6,
      curso: 2,
      ciclo: 'DAM',
      imagen: '',
      conocimientos: ['Java', 'Js', 'Angular', 'JavaFX'],
    },
    {
      nombre: 'Programacion',
      siglas: 'PRO',
      horas: 8,
      curso: 1,
      ciclo: 'DAM|DAW',
      imagen: '',
      conocimientos: ['Java', 'JDBC'],
    },
    {
      nombre: 'Base Datos',
      siglas: 'BD',
      horas: 6,
      curso: 1,
      ciclo: 'DAM|DAW|ASIR',
      imagen: '',
      conocimientos: ['MySQL', 'Mongo'],
    },
    {
      nombre: 'Implantacion de sistemas opetativos',
      siglas: 'ISO',
      horas: 8,
      curso: 1,
      ciclo: 'ASIR',
      imagen: '',
      conocimientos: ['Windows', 'Linux', 'Powershell', 'Bash'],
    },
    {
      nombre: 'Desarrollo cliente',
      siglas: 'DAWC',
      horas: 6,
      curso: 2,
      ciclo: 'DAW',
      imagen: '',
      conocimientos: ['Js', 'React', 'React Native'],
    },
    {
      nombre: 'Desarrollo servidor',
      siglas: 'DAWC',
      horas: 9,
      curso: 2,
      ciclo: 'DAW',
      imagen: '',
      conocimientos: ['PHP', 'Python'],
    },
    {
      nombre: 'Administacion de sistemas operativos',
      siglas: 'ASO',
      horas: 6,
      curso: 2,
      ciclo: 'ASIR',
      imagen: '',
      conocimientos: [
        'Servidores',
        'Linux',
        'Windows',
        'PowerShell',
        'AD',
        'Bash',
      ],
    },

    {
      nombre: 'Implantacion de Aplicaciones Web',
      siglas: 'IAW',
      horas: 6,
      curso: 2,
      ciclo: 'ASIR',
      imagen: '',
      conocimientos: ['JS', 'Bash'],
    },
  ];
}
