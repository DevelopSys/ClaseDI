import { Component } from '@angular/core';
import { tarea } from '../../model/tarea';
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-listar',
  standalone: false,
  templateUrl: './listar.html',
  styleUrl: './listar.css',
})
export class Listar {
  tareas: tarea[] = [];
  constructor(private tareasSevice: Tareas) {
    this.tareas = this.tareasSevice.getTareas();
  }
}
