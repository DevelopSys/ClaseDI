import { Component } from '@angular/core';
import { asignatura } from '../../model/asignatura';
import { AsignaturasService } from '../../services/asignaturas.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.css',
})
export class CursosComponent {
  asignaturas: asignatura[] = [];

  constructor(private servicio: AsignaturasService) {
    this.asignaturas = servicio.getAllAsignaturasCurso('DAW');
  }
}
