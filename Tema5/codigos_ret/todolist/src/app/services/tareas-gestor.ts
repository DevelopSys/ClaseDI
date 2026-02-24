import { Injectable } from '@angular/core';
import { Tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root',
})
export class TareasGestor {
  // la lista de todas las tareas

  private listaTareas: Tarea[] = [];
  private contador: number = 0;

  public addTarea(tarea: Tarea) {
    this.contador += 1;
    tarea.id = this.contador;
    this.listaTareas.push(tarea);
  }

  public getAllTareas(): Tarea[] {
    return this.listaTareas;
  }

  public getTareasPrioridad(prioridad: number) {
    return this.listaTareas.filter((item) => item.prioridad == prioridad);
  }
}
