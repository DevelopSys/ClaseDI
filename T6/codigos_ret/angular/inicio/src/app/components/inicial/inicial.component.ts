import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';

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
    this.listaTareas.push(
      new Tarea(
        this.nombreValor,
        this.descripcionValor,
        this.estadoValor,
        this.prioridadValor
      )
    );
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
