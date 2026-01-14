import { Component, signal } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('inicial');
  nombre: string = 'Borja';
  apellido: string = 'Martin Herrera';
  curso: number = 1;
  nombreCurso: string = 'DAM';
  nota: number = 0;

  pulsarComenzar(notaInput: string) {
    // escribir el mensaje y que ponga la nota introducida dentro del input
    // como puedo sabes si notaInput es un numero??????????
    /* if (isNaN(Number(notaInput))) {
      } else {
        } */
    // this.nota = Number(notaInput);
    Swal.fire({
      title: 'Error!',
      text: 'Do you want to continue',
      icon: 'error',
      confirmButtonText: 'Cool',
    });
  }
}
