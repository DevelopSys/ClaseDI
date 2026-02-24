import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import { TareasGestor } from '../../services/tareas-gestor';
import { CommonModule } from '@angular/common';
import { ImagenesPipe } from '../../pipes/imagenes-pipe';
import { CartaTarea } from '../carta-tarea/carta-tarea';

@Component({
  selector: 'app-list',
  imports: [CommonModule, CartaTarea],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List {
  listaTareas: Tarea[] = [];

  constructor(private gestor: TareasGestor) {
    this.listaTareas = gestor.getAllTareas();
  }
}
