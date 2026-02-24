import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import { TareasGestor } from '../../services/tareas-gestor';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-detalle',
  imports: [CommonModule],
  templateUrl: './detalle.html',
  styleUrl: './detalle.css',
})
export class Detalle {
  tarea?: Tarea;
  recuperado: string = '0';

  constructor(
    private gestorTareas: TareasGestor,
    private gestorRutas: ActivatedRoute,
  ) {
    this.gestorRutas.paramMap.subscribe((data) => {
      this.recuperado = data.get('id') ?? '-1';
      this.tarea = this.gestorTareas.getTareasById(Number(this.recuperado));
    });
  }
}
