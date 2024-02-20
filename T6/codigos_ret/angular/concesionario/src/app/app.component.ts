import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'concesionario';
  seleccionComponente = '1';
  // nada mas crearse el componente necestio el modulo Router

  constructor(private router: Router) {}

  navegarLogico(destino: string) {
    // al pular el elemento navego a "motos"
    this.router.navigate([`${destino}`]);
  }

  navegarParametros() {
    this.router.navigate(['motos', 'venta']);
  }
}
