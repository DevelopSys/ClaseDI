import { Injectable } from '@angular/core';
import { Tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root',
})
export class TareasService {
  // tener los datos
  tareas: Tarea[] = [];

  constructor() {}

  lanzarDatos() {
    console.log('El numero de tareas actuales es de ' + this.tareas.length);
  }

  agregarTarea(tarea: Tarea) {
    this.tareas.push(tarea);
  }

  getAllTareas(): Tarea[] {
    return this.tareas;
  }
}
