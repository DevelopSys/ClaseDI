import { Component } from '@angular/core';
import { Asignatura } from '../../model/curso';
import { Profesor } from '../../model/profesor';
import { AcademiaService } from '../../services/academia.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'academia-asignacion',
  templateUrl: './asignacion.component.html',
  styleUrl: './asignacion.component.css',
})
export class AsignacionComponent {
  asignaturas: Asignatura[] = [];
  profesores: Profesor[] = [];

  asignaturaSeleccinada: Asignatura | null = null;
  profesorSeleccionado: Profesor | null = null;

  constructor(private servicio: AcademiaService) {
    this.asignaturas = servicio.getAllAsignaturas();
    this.profesores = servicio.getAllProfesores();
  }

  asociarProfesor() {
    let asign = this.servicio.getAsignaturaNombre(
      this.asignaturaSeleccinada!.nombre
    );
    if (asign?.profesor == null) {
      this.servicio.actualizarProfesor(
        asign!.nombre,
        this.profesorSeleccionado!
      );
    } else {
      Swal.fire({
        title: 'Asignatura con profesor asociado',
        text: 'Quieres cambiar de profesor?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, cambiar',
      }).then((result) => {
        if (result.isConfirmed) {
          this.servicio.addProfesor(this.profesorSeleccionado!!);
          this.servicio.actualizarProfesor(
            this.asignaturaSeleccinada!.nombre,
            this.profesorSeleccionado!
          );
        }
      });
    }
  }
}
