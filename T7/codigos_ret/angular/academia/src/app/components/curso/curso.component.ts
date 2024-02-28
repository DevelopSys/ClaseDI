import { Component } from '@angular/core';
import { Asignatura } from '../../model/curso';
import { AcademiaService } from '../../services/academia.service';

@Component({
  selector: 'academia-curso',
  templateUrl: './curso.component.html',
  styleUrl: './curso.component.css',
})
export class CursoComponent {
  /*  quiero acceder a todas las asignaturas */

  asignaturas: Asignatura[] = [];

  constructor(private servicio: AcademiaService) {
    // agregar una asignatura??????
    this.servicio.putAsignatura({
      id: 6,
      nombre: 'Implantacion de sistemas operativos',
      siglas: 'ISO',
      horas: 8,
      conocimientos: ['Windows', 'Linux', 'Ps', 'Bash'],
      ciclo: 'ASIR',
      nivel: 1,
      profesor: null,
      imagen:
        'https://concepto.de/wp-content/uploads/2018/02/sistemas-de-informacion.jpg',
    });
    this.asignaturas = servicio.getAllAsignaturas();
  }
}
