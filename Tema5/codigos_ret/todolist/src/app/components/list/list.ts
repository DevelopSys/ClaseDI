import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import { TareasGestor } from '../../services/tareas-gestor';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list',
  imports: [CommonModule],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List {
  listaTareas: Tarea[] = [];

  constructor(private gestor: TareasGestor) {
    this.listaTareas = gestor.getAllTareas();
  }
}
