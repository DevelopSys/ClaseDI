import { Component } from '@angular/core';
import { Asignatura } from '../../model/curso';
import { AcademiaService } from '../../services/academia.service';
import { Profesor } from '../../model/profesor';
import Swal from 'sweetalert2';

@Component({
  selector: 'academia-contratacion',
  templateUrl: './contratacion.component.html',
  styleUrl: './contratacion.component.css',
})
export class ContratacionComponent {
  asignaturas: Asignatura[] = [];
  nombre: string = '';
  apellido: string = '';
  dni: string = '';
  conocimientosEntrada: string = '';
  asignatura: string = '';

  constructor(private servicio: AcademiaService) {
    this.asignaturas = servicio.getAllAsignaturas();
  }

  contratarProfesor() {
    let profesor = new Profesor(
      this.nombre,
      this.apellido,
      this.dni,
      this.conocimientosEntrada.split(',')
    );

    let asignatura = this.servicio.getAsignaturaNombre(this.asignatura);

    if (asignatura?.profesor == null) {
      this.servicio.addProfesor(profesor);
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Profesor contratado',
        showConfirmButton: false,
        timer: 1500,
      });
      this.servicio.actualizarProfesor(asignatura!.nombre, profesor);
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
          this.servicio.addProfesor(profesor);
          this.servicio.actualizarProfesor(asignatura!.nombre, profesor);
        }
      });
      // pregunta del cambio
      // this.servicio.addProfesor(profesor);
    }
  }
}
