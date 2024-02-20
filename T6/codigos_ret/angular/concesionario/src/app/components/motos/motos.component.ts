import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-motos',
  templateUrl: './motos.component.html',
  styleUrl: './motos.component.css',
})
export class MotosComponent {
  /* necesito el modulo ActivatedRoute */

  constructor(private rutaActiva: ActivatedRoute) {
    console.log(this.rutaActiva.snapshot.params['tipo']);
  }
}
