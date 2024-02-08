import { Component } from '@angular/core';

@Component({
  selector: 'app-concesionario',
  templateUrl: './concesionario.component.html',
  styleUrl: './concesionario.component.css',
})
export class ConcesionarioComponent {
  marca: string = '';
  modelo: string = '';
  matricula: string = '';
  cv: Number = 0;
  cc: Number = 0;
  precio: Number = 0;
  motor: string = '';
}
