import { Component } from '@angular/core';
import { Asignatura } from '../../model/curso';
import { AcademiaService } from '../../services/academia.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'academia-curso',
  templateUrl: './curso.component.html',
  styleUrl: './curso.component.css',
})
export class CursoComponent {
  /*  quiero acceder a todas las asignaturas */

  asignaturas: Asignatura[] = [];
  curso: any = '';

  constructor(
    private servicio: AcademiaService,
    private ruta: ActivatedRoute,
    private navegacion: Router
  ) {
    // agregar una asignatura??????
    // ruta.snapshot.params['curso'];
    ruta.paramMap.subscribe((it: ParamMap) => {
      this.curso = it.get('curso')?.toString();
      console.log(this.curso);
      this.asignaturas = this.servicio.getAsignaturasCurso(this.curso);
    });
  }

  navegar(id: Number) {
    this.navegacion.navigate(['detalle', id]);
  }
}
