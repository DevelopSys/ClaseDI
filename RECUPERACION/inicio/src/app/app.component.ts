import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'inicio';
  nombre = 'Borja';
  curso = 'Desarrollo de Aplicaciones Multiplataforma';
  verIf = false;
  asignatura = 'Desarrollo de interfaces';
  contador = -10;
  numerover = 1;
  usuarios: string[] = ['usuario1', 'usuario2', 'usuario3', 'usuario4'];
  nombreAnadir = '';

  anadirUsuario() {
    this.usuarios.push(this.nombreAnadir);
    this.nombreAnadir = '';
  }

  incrementarContador(numero: string) {
    this.contador += Number(numero);
  }

  resetearContador(numero: string) {
    this.contador = Number(numero);
  }
}
