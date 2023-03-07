import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'rutas_ret';

  constructor(private navegador: Router) {}

  navegar() {
    // Router
    this.navegador.navigate(['cursos', 'todos']);
  }
}
