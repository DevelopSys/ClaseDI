import { Component } from '@angular/core';
import { Coche } from '../../model/coche';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-concesionario',
  templateUrl: './concesionario.component.html',
  styleUrl: './concesionario.component.css',
})
export class ConcesionarioComponent {
  marca: string = '';
  modelo: string = '';
  matricula: string = '';
  cv: number = 0;
  cc: number = 0;
  precio: number = 0;
  motor: string = '';
  titulo = "Formulario de búsqueda"
  imagenDefecto = "https://img.freepik.com/psd-premium/coche-moderno-sobre-fondo-transparente-representacion-3d-ilustracion_494250-31500.jpg"

  coches: Coche[] = [];

  agregarCoche() {
    if (
      this.marca.length > 0 &&
      this.modelo.length > 0 &&
      this.matricula.length > 0 &&
      this.precio > 0 &&
      this.cc > 0 &&
      this.cc > 0
    ) {
      this.coches.push(
        new Coche(
          this.marca,
          this.modelo,
          this.matricula,
          this.cv,
          this.cc,
          this.precio,
          this.motor
        )
      );

      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Coche añadido con exito',
        showConfirmButton: false,
        timer: 1500,
      });

      this.limpiarDatos();
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No hay datos suficientes',
      });
    }
  }
  limpiarDatos() {
    this.marca = '';
    this.modelo = '';
    this.matricula = '';
    this.cc = 0;
    this.cv = 0;
    this.precio = 0;
    this.motor = '';
  }
}
