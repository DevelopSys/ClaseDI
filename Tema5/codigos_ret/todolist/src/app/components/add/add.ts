import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Tarea } from '../../model/tarea';
import { TareasGestor } from '../../services/tareas-gestor';

@Component({
  selector: 'app-add',
  imports: [FormsModule],
  templateUrl: './add.html',
  styleUrl: './add.css',
})
export class Add {
  titulo?: string;
  responsable?: string;
  fecha?: string;
  prioridad?: number; // 1-baja // 2-media // 3-alta

  constructor(private gestor: TareasGestor) {}

  procesarTarea() {
    // estan todo los campos rellenos -> sweetAlert
    let tarea: Tarea = {
      id: 0,
      titulo: this.titulo!!,
      responsable: this.responsable!!,
      fecha: this.fecha!!,
      prioridad: Number(this.prioridad!!),
    };

    this.gestor.addTarea(tarea);

    // agregar al array definido dentro del servicio

    // limpiado de campos
  }
}
