import { Component } from '@angular/core';
import { AcademiaService } from '../../services/academia.service';
import { Alumno } from '../../model/alumno';

@Component({
  selector: 'academia-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  nia: string = '';
  nombre: string = '';
  apellido: string = '';
  dni: string = '';
  ciclo: string = '';

  constructor(private servicio: AcademiaService) {}

  matricularAlumno() {
    this.servicio.putAlumno(
      new Alumno(
        this.nombre,
        this.apellido,
        this.dni,
        Number(this.nia),
        this.ciclo
      )
    );

    this.limpiarDatos(
      this.nia,
      this.nombre,
      this.apellido,
      this.ciclo,
      this.dni
    );

    this.limpiarDatos(
      this.apellido,
      this.ciclo,
      this.dni,
      this.nombre,
      this.nia
    );
  }

  limpiarDatos(...elementos: any) {
    elementos.forEach((item: any) => {
      item = '';
    });
  }
}
