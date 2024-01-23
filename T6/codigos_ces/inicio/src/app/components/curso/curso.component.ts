import { Component } from '@angular/core';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrl: './curso.component.css',
})
export class CursoComponent {
  nombre: String = '';
  pass: String = '';
  curso: String = '';
  mostrar: boolean = false;

  metodoPulsacion(nombre: String, pass: String, curso: String) {
    this.nombre = nombre;
    this.pass = pass;
    this.curso = curso;
    this.mostrar = true;
  }
  seleccionCurso(curso: String) {}
}
