import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Curso } from '../../model/curso';
import { Asignatura } from '../../model/asignatura';
import { DatosService } from '../../services/datos.service';

@Component({
  selector: 'app-detalle',
  standalone: false,

  templateUrl: './detalle.component.html',
  styleUrl: './detalle.component.css',
})
export class DetalleComponent {
  tipo: string = '';
  id: number = 0;
  dato: Curso | Asignatura | undefined;

  constructor(private activatedRoute: ActivatedRoute, private servicio: DatosService) {
    this.activatedRoute.params.subscribe((params) => {
      this.id = params['id'];
      this.tipo = params['tipo'];
      this.dato = servicio.getAllCursos(params['id'])
    });
  }
}
