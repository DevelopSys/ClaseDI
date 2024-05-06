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
  asignatura = 'Desarrollo de interfaces';
  contador = -10;

  incrementarContador(numero: string) {
    this.contador += Number(numero);
  }

  resetearContador(numero: string) {
    this.contador = Number(numero);
  }
}
