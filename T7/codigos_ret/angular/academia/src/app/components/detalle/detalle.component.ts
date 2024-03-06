import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { AcademiaService } from '../../services/academia.service';
import { Asignatura } from '../../model/curso';

@Component({
  selector: 'academia-detalle',
  templateUrl: './detalle.component.html',
  styleUrl: './detalle.component.css',
})
export class DetalleComponent {
  asignatura: Asignatura | undefined = undefined;

  constructor(
    private rutaActiva: ActivatedRoute,
    private servicio: AcademiaService
  ) {
    this.rutaActiva.paramMap.subscribe((item: ParamMap) => {
      let identificador: Number = Number(item.get('id'));
      this.asignatura = this.servicio.getAsignaturaId(identificador);
      console.log(this.asignatura);
    });
  }
}
