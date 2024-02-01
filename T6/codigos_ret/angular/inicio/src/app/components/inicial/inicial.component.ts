import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-inicial',
  templateUrl: './inicial.component.html',
  styleUrl: './inicial.component.css',
})
export class InicialComponent {
  estado: string = '';
  prioridad: string = '';
  listaTareas: Tarea[] = [];
  nombreValor = '';
  descripcionValor = '';
  estadoValor = '';
  prioridadValor = '';

  agregarTarea() {
    if (
      this.nombreValor.length > 0 &&
      this.descripcionValor.length > 0 &&
      this.estadoValor.length > 0 &&
      this.prioridadValor.length > 0
    ) {
      this.listaTareas.push(
        new Tarea(
          this.nombreValor,
          this.descripcionValor,
          this.estadoValor,
          this.prioridadValor
        )
      );

      new Promise((res, rej) => {
        res('elemento agregado correctamente');
      }).then((res) => {
        Swal.fire({
          icon: 'success',
          title: 'Añadido ok',
          text: `${res}`,
        });
      });
    } else {
      new Promise((res, rej) => {
        res('faltan datos');
      }).then((res) => {
        Swal.fire({
          icon: 'error',
          title: 'Error al añadir',
          text: `${res}`,
        });
      });
    }

    // dato del nombre y la descripcion se vacien
    this.nombreValor = '';
    this.descripcionValor = '';
    this.estadoValor = '';
    this.prioridadValor = '';
  }

  mostrarDatos(nombre: string, descripcion: string) {
    alert(`Datos recibidos ${nombre} ${descripcion}`);
  }

  cambiarDatos(evento: Event) {
    console.log((evento.target as HTMLSelectElement).value);
  }
}

/* Al agregar una tarea
  1. Si todos los datos estan rellenos y se agrega la tarea -> alert("Confirmacion")
  2. No hay datos en algun campo-> mensaje de error

*/
