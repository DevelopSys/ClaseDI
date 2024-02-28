import { Component } from '@angular/core';
import { AcademiaService } from '../../services/academia.service';

@Component({
  selector: 'academia-general',
  templateUrl: './general.component.html',
  styleUrl: './general.component.css',
})
export class GeneralComponent {
  constructor(private servicio: AcademiaService) {
    this.servicio.getAllAsignaturas().forEach((it) => {
      console.log(it.nombre);
    });
  }
}
