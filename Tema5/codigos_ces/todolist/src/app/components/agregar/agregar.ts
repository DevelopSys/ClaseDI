import { Component } from '@angular/core';
import { tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-agregar',
  standalone: false,
  templateUrl: './agregar.html',
  styleUrl: './agregar.css',
})
export class Agregar {
  items: string[] = [];
  nombre?: string;
  fecha?: string;
  responsable?: string;
  prioridad?: string;
  descripcion?: string;
  item?: string;
  tareas: tarea[] = [];

  constructor(private tareasServicio: Tareas) {
    // logica
  }

  agregarItem() {
    if (this.item != undefined) {
      this.items.push(this.item);
    } else {
      // saltar un aviso
    }
  }

  agregarTarea() {
    /* if(){
      items.length == 0
    } else {

    } */
    let tarea: tarea = {
      nombre: this.nombre,
      responsable: this.responsable,
      items: this.items,
      fecha: this.fecha,
      prioridad: Number(this.prioridad),
      descipcion: this.descripcion,
    };

    // llamar al metodo agregarTarea del servicio
    this.tareasServicio.agregarTarea(tarea);

    // limpiar los campos
    // vaciar el array
    this.items = [];
  }
}
