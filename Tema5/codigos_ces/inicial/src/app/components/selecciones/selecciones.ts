import { Component } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-selecciones',
  standalone: false,
  templateUrl: './selecciones.html',
  styleUrl: './selecciones.css',
})
export class Selecciones {
  seleccion = '1';
  tipoPago = '1';

  validarCompra() {
    Swal.fire('SweetAlert2 is working!');
  }
}
