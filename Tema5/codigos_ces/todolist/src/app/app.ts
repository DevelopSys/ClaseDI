import { Component, signal } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('todolist');
  opcion: string = '1';

  constructor(private gestorRutas: Router) {}

  navegar(parm: string) {
    // cuando tenga algun procesamiento de datos
    this.gestorRutas.navigate(['buscar', parm]);
  }
}
