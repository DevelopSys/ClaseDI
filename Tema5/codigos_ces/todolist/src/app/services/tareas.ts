import { Injectable } from '@angular/core';
import { tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root',
})
export class Tareas {
  tareas: tarea[] = [
    {
      nombre: 't1',
      responsable: 'R1',
      items: [],
      fecha: '',
      prioridad: 1,
      descipcion: 'Ejemplo t1',
    },
    {
      nombre: 't2',
      responsable: 'R2',
      items: [],
      fecha: '',
      prioridad: 2,
      descipcion: 'Ejemplo t2',
    },
    {
      nombre: 't3',
      responsable: 'R1',
      items: [],
      fecha: '',
      prioridad: 3,
      descipcion: 'Ejemplo t3',
    },
    {
      nombre: 't4',
      responsable: 'R1',
      items: [],
      fecha: '',
      prioridad: 1,
      descipcion: 'Ejemplo t4',
    },
    {
      nombre: 't5',
      responsable: 'R5',
      items: [],
      fecha: '',
      prioridad: 1,
      descipcion: 'Ejemplo t5',
    },
    {
      nombre: 't6',
      responsable: 'R7',
      items: [],
      fecha: '',
      prioridad: 2,
      descipcion: 'Ejemplo t7',
    },
  ];

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
