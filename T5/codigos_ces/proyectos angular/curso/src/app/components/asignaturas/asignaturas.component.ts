import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-asignaturas',
  standalone: false,

  templateUrl: './asignaturas.component.html',
  styleUrl: './asignaturas.component.css',
})
export class AsignaturasComponent {
  constructor(private router: Router) {}

  navegar() {
    this.router.navigate(['/detalle', 'asignatura', 1]);
  }
}
