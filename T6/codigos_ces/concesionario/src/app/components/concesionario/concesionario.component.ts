import { Component } from '@angular/core';
import { Coche, CocheClase } from '../../model/coche';
import Swal from 'sweetalert2';

// or via CommonJS

@Component({
  selector: 'concesionario-concesionario',
  templateUrl: './concesionario.component.html',
  styleUrl: './concesionario.component.css',
})
export class ConcesionarioComponent {
  concesionario = 'Concesionario SL';
  imagenConcesionario = '';
  marca: string = '';
  modelo: string = '';
  matricula: string = '';
  cv: string = '';
  cc: string = '';
  motor: string = '';
  precio: string = '';
  motorBuscar: string = '';
  matriculaBuscar: string = '';
  listado: CocheClase[] = [];
  listaCocheBuscado: any[] = [];
  listadoCochesMotor: CocheClase[] = [];

  agregarCoche() {
    if (
      this.marca.length > 0 &&
      this.modelo.length > 0 &&
      this.matricula.length > 0 &&
      Number(this.cc) > 0 &&
      Number(this.cv) > 0 &&
      Number(this.precio) > 0
    ) {
      this.listado.push(
        new CocheClase(
          this.marca,
          this.modelo,
          Number(this.cv),
          Number(this.cc),
          this.matricula,
          Number(this.precio),
          this.motor
        )
      );

      this.marca = '';
      this.modelo = '';
      this.cv = '';
      this.cc = '';
      this.matricula = '';
      this.motor = '';
      this.precio = '';

      Swal.fire({
        title: 'Correcto',
        text: 'Coche agregado correctamente',
        icon: 'success',
        confirmButtonText: 'Cool',
      });
    } else {
      Swal.fire({
        title: 'Error!',
        text: 'Faltan datos',
        icon: 'error',
        confirmButtonText: 'Cool',
      });
    }
  }

  buscarCoche(matricula: string) {
    this.listaCocheBuscado = [];
    let cocheBuscado = this.listado.find((item: CocheClase) => {
      return item.getMatricula == matricula;
    });

    this.listaCocheBuscado.push(cocheBuscado);
  }

  buscarTipoMotor(motor: string) {
    this.listadoCochesMotor = this.listado.filter((item: CocheClase) => {
      return item.getMotor.toLowerCase() == motor.toLowerCase();
    });
  }
}
