import { Component } from '@angular/core';
import { asignatura } from '../../model/asignatura';
import { AsignaturasService } from '../../services/asignaturas.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.css',
})
export class CursosComponent {
  asignaturas: asignatura[] = [];
 

  constructor(private servicio: AsignaturasService){
    this.asignaturas = this.servicio.getAllAsignaturas()
  }


 // 1.  crear un componente que se llame buscador
 // 2.  Crear una ruta para poder navegar a el
 // 3.  Crear un buscador en el componente que consuma datos del servido
    // Buscar por conocimiento
    // Buscar por curso
    // Buscar por profesor
  
}
