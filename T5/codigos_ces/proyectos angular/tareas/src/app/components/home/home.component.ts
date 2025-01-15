import { Component } from '@angular/core';
import Swal from 'sweetalert2';

import { log } from 'node:console';

@Component({
  selector: 'app-home',
  standalone: false,

  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  nombre: String = 'Borja';
  asignatura: String = 'PMDM';
  experiencia = false;
  imagen =
    'https://angular.dev/assets/images/press-kit/angular_wordmark_gradient.png';

  cambiarFondo() {
    this.imagen =
      'https://logowik.com/content/uploads/images/angular9826.logowik.com.webp';
  }

  obtenerDatos(nombre: String, apellido: String, correo: String) {
    Swal.fire({
      title: 'Error!',
      text: 'Do you want to continue',
      icon: 'error',
      confirmButtonText: 'Cool',
    });
  }
}
