import { Component } from '@angular/core';
import { Profesor } from '../../model/profesor';
import { AcademiaService } from '../../services/academia.service';
import { Asignatura } from '../../model/curso';

@Component({
  selector: 'academia-buscador',
  templateUrl: './buscador.component.html',
  styleUrl: './buscador.component.css',
})
export class BuscadorComponent {
  nombre: string = '';

  asignaturas: Asignatura[] | any = [];

  constructor(private servicio: AcademiaService) {}
  buscar() {
    this.asignaturas = this.servicio.getAllAsignaturaNombre(this.nombre);
    console.log(this.asignaturas);
  }
}
