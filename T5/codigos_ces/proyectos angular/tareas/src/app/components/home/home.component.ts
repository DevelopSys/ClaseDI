import { Component } from '@angular/core';
import Swal from 'sweetalert2';

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
  opcion = 'Seleccionar opcion';
  imagen =
    'https://angular.dev/assets/images/press-kit/angular_wordmark_gradient.png';

  cambioSelect(event: Event) {
    console.log((event.target as HTMLSelectElement).value);
    //this.mostrarDatos((event.target as HTMLSelectElement).value);
  }

  mostrarDatos(dato: String) {}

  cambiarFondo() {
    this.imagen =
      'https://logowik.com/content/uploads/images/angular9826.logowik.com.webp';
  }

  obtenerDatos(
    nombre: String,
    apellido: String,
    correo: String,
    opcion: String
  ) {
    if (nombre.length > 0 && apellido.length > 0 && correo.length > 0) {
      Swal.fire({
        title: 'Exito!',
        text: 'Opcion: ' + opcion,
        icon: 'success',
        confirmButtonText: 'Cool',
      });
    } else {
      Swal.fire({
        title: 'Error!',
        text: 'Error al sacar los datos',
        icon: 'error',
        confirmButtonText: 'Cool',
      });
    }
  }
}
