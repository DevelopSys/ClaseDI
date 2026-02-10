import { Component, OnInit } from '@angular/core';
import { tarea } from '../../model/tarea';
import { ActivatedRoute } from '@angular/router';
import { Tareas } from '../../services/tareas';

@Component({
  selector: 'app-detail',
  standalone: false,
  templateUrl: './detail.html',
  styleUrl: './detail.css',
})
export class Detail {
  tarea?: tarea;

  constructor(
    private gestorRutasActivas: ActivatedRoute,
    private servicioTareas: Tareas,
  ) {
    let dato: string = this.gestorRutasActivas.snapshot.params['id'];
    this.tarea = this.servicioTareas.getTareaById(Number(dato));
  }
}
