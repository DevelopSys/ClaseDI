import { DatosService } from './../../services/datos.service';
import { Component, OnInit } from '@angular/core';
import { Asignatura } from 'src/app/utils/Asignatura';

@Component({
  selector: 'app-asignaturas',
  templateUrl: './asignaturas.component.html',
  styleUrls: ['./asignaturas.component.css']
})
export class AsignaturasComponent implements OnInit {

  asignaturasPintar: Asignatura[];

  constructor(private servicio: DatosService) { }

  ngOnInit(): void {
    this.asignaturasPintar = this.servicio.getAsignaturas()
  }

}
