import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Curso } from '../../model/curso';
import { Asignatura } from '../../model/asignatura';

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

  constructor(private activatedRoute: ActivatedRoute) {
    this.activatedRoute.params.subscribe((params) => {
      this.id = params['id'];
      this.tipo = params['tipo'];
    });
  }
}
