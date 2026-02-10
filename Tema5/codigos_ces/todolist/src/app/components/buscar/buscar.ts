import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Tareas } from '../../services/tareas';
import { tarea } from '../../model/tarea';

@Component({
  selector: 'app-buscar',
  standalone: false,
  templateUrl: './buscar.html',
  styleUrl: './buscar.css',
})
export class Buscar {
  prioridad?: string;
  tareas: tarea[] = [];
  filtradas: tarea[] = [];
  busqueda: boolean = false;
  responsable: string | undefined;

  constructor(
    private gestorRutasActivas: ActivatedRoute,
    private servicioTareas: Tareas,
  ) {
    // this.prioridad = gestorRutasActivas.snapshot.params['id'];
    this.gestorRutasActivas.paramMap.subscribe((item) => {
      this.busqueda = false;
      this.prioridad = item.get('id') ?? undefined;
      if (Number(this.prioridad) == 4) {
        this.tareas = this.servicioTareas.getTareas();
      } else {
        this.tareas = this.servicioTareas.getTareasPrioridad(this.prioridad);
      }
      this.filtradas = this.tareas;
    });
  }

  realizarBusqueda() {
    this.filtradas = this.tareas.filter((item) => item.responsable == this.responsable);
    this.busqueda = true;
    // capturar las tareas que ya estan y pintar las correctas
  }
}
