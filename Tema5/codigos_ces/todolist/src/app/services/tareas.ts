import { Injectable } from '@angular/core';
import { tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root',
})
export class Tareas {
  contador = 7;
  tareas: tarea[] = [
    {
      id: 1,
      nombre: 't1',
      responsable: 'R1',
      items: [],
      fecha: '',
      prioridad: 1,
      descipcion: 'Ejemplo t1',
    },
    {
      id: 2,
      nombre: 't2',
      responsable: 'R2',
      items: [],
      fecha: '',
      prioridad: 2,
      descipcion: 'Ejemplo t2',
    },
    {
      id: 3,
      nombre: 't3',
      responsable: 'R1',
      items: [],
      fecha: '',
      prioridad: 3,
      descipcion: 'Ejemplo t3',
    },
    {
      id: 4,
      nombre: 't4',
      responsable: 'R1',
      items: [],
      fecha: '',
      prioridad: 1,
      descipcion: 'Ejemplo t4',
    },
    {
      id: 5,
      nombre: 't5',
      responsable: 'R5',
      items: [],
      fecha: '',
      prioridad: 1,
      descipcion: 'Ejemplo t5',
    },
    {
      id: 6,
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
    tarea.id = this.contador;
    this.tareas.push(tarea);
    this.contador++;
  }
  // obtener todas las tareas
  getTareas(): tarea[] {
    return this.tareas;
  }

  getTareasPrioridad(numero: string | undefined): tarea[] {
    return this.tareas.filter((tarea) => tarea.prioridad == Number(numero));
  }

  getTareaById(param: Number): tarea {
    return this.tareas.find((item) => item.id == param) as tarea;
  }

  // obtener todas las tareas por prioridad
}
