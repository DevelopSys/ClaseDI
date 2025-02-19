import { Component } from '@angular/core';
import { TareasService } from '../../services/tareas.service';
import { Tarea } from '../../model/tarea';

@Component({
  selector: 'app-list',
  standalone: false,
  templateUrl: './list.component.html',
  styleUrl: './list.component.css',
})
export class ListComponent {
  listaTareas: Tarea[] = [];

  constructor(private servicio: TareasService) {
    this.listaTareas = servicio.getAllTareas();
  }
}
