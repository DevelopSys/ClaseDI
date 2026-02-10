import { Component, Input } from '@angular/core';
import { tarea } from '../../model/tarea';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carta',
  standalone: false,
  templateUrl: './carta.html',
  styleUrl: './carta.css',
})
export class Carta {
  @Input() item?: tarea;

  constructor(private gestorRutas: Router) {}

  verDetalle(id: number) {
    this.gestorRutas.navigate(['detalle', id]);
  }
}
