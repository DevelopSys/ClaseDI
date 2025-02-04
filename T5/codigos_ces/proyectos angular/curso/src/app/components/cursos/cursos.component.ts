import { Component } from '@angular/core';
import { Curso } from '../../model/curso';
import { DatosService } from '../../services/datos.service';

@Component({
  selector: 'app-cursos',
  standalone: false,

  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.css',
})
export class CursosComponent {
  // pintar todos los cursos
  cursos: Curso[] = [];

  constructor(private servicioCursos: DatosService) {
    this.cursos = servicioCursos.getAllCursos();
  }
}
