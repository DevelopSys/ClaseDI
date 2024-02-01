import { Component } from '@angular/core';
import { asignatura } from '../../model/asignatura';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.css',
})
export class CursosComponent {
  asignaturas: asignatura[] = [
    {
      nombre: 'Programacion',
      siglas: 'PRO',
      horas: 8,
      profesor: 'Borja Martin Herrera',
      curso: 'DAM|DAW',
      nivel: 1,
      conocimientos: ['Java', 'MySQL', 'Algoritmos', 'Ficheros'],
      imagen:
        'https://ubiqum.com/assets/uploads/2021/12/learn-java-with-ubiqum-logo.png',
    },
    {
      nombre: 'Sistemas',
      siglas: 'SI',
      horas: 6,
      profesor: 'Luis Miguel Serrano',
      curso: 'DAM|DAW',
      nivel: 1,
      conocimientos: ['Windows', 'Linux', 'Bash', 'Powershell'],
      imagen:
        'https://www.lifeder.com/wp-content/uploads/2021/11/sistemas-1.jpg',
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
  ];
}
