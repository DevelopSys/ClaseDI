import { Component } from '@angular/core';
import { TareasService } from '../../services/tareas.service';

@Component({
  selector: 'app-add',
  standalone: false,
  templateUrl: './add.component.html',
  styleUrl: './add.component.css',
})
export class AddComponent {
  constructor(private servicio: TareasService) {}

  agregarTarea() {
    this.servicio.lanzarDatos();
    // capturo los campos del formulario -> variables de la clase, form (JSON), paramentros del metodo
    // agregarlo en la parte de datos -> []
    // desde el servicio, agregar una tarea
  }
}
