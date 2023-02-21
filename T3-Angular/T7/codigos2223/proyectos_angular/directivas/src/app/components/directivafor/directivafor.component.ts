import { Component } from '@angular/core';
import { Asignatura } from 'src/app/model/asignatura';
import { AsignaturasService } from 'src/app/services/asignaturas.service';

@Component({
  selector: 'directivas-directivafor',
  templateUrl: './directivafor.component.html',
  styleUrls: ['./directivafor.component.css'],
})
export class DirectivaforComponent {
  elementos: string[] = ['Elemento1', 'Elemento2', 'Elemento3'];

  asignaturas: Asignatura[];

  constructor(private servicioAsignaturas: AsignaturasService) {
    this.asignaturas = servicioAsignaturas.getAllAsignaturas();
  }

  anadirElemento(dato: string) {
    this.elementos.push(dato);
  }

  evaluarCambio(evento: any) {
    let curso = Number(evento.target.value);
    this.asignaturas = this.servicioAsignaturas.getAsignaturasFiltradas(curso);
  }
}
