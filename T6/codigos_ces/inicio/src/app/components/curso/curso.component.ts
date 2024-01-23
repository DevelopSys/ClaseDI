import { Component } from '@angular/core';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrl: './curso.component.css',
})
export class CursoComponent {
  nombre: String = '';
  pass: String = '';

  metodoPulsacion(nombre: String, pass: String) {
    this.nombre = nombre;
    this.pass = pass;
  }
}
