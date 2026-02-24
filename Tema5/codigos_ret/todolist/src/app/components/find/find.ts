import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Tarea } from '../../model/tarea';
import { TareasGestor } from '../../services/tareas-gestor';
import { ImagenesPipe } from '../../pipes/imagenes-pipe';
import { CartaTarea } from '../carta-tarea/carta-tarea';

@Component({
  selector: 'app-find',
  imports: [FormsModule, CommonModule, CartaTarea],
  templateUrl: './find.html',
  styleUrl: './find.css',
})
export class Find {
  busando = false;
  prioridad?: number;
  tareas: Tarea[] = [];

  constructor(private gestor: TareasGestor) {}

  realizarBusqueda() {
    this.busando = true;
    this.tareas = this.gestor.getTareasPrioridad(this.prioridad!!);
  }
}
