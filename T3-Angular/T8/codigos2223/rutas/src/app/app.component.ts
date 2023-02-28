import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'rutas-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'rutas';
  // navegar
  constructor(private gestorRutas: Router) {}

  navegarComponente(dato: string) {
    this.gestorRutas.navigate(['comunicar', Number(dato)]);
  }
}
