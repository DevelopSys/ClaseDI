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
  usuarios: String[] = ['usuario1', 'usuario2', 'usuario3', 'usuario4'];

  metodoPulsacion(nombre: String, pass: String, curso: String) {
    this.nombre = nombre;
    this.pass = pass;
    this.curso = curso;
    this.mostrar = true;
    this.usuarios.push(nombre);
  }
  seleccionCurso(curso: String) {}
}
