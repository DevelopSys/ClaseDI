import { Injectable } from '@angular/core';
import { tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root',
})
export class Tareas {
  tareas: tarea[] = [];

  // agregar una tarea
  agregarTarea(tarea: tarea) {
    // no se pueden crear tareas con un responsable que ya este en otra tarea
    this.tareas.push(tarea);
  }
  // obtener todas las tareas
  getTareas(): tarea[] {
    return this.tareas;
  }

  // obtener todas las tareas por prioridad
}
