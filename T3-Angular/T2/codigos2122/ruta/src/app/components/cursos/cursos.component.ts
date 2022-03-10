import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { AsignaturasService } from 'src/app/services/asignaturas.service';
import { asignatura } from 'src/app/utils/asignatura';

@Component({
  selector: 'rutas-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent implements OnInit {
  curso: string = 'DAM';

  asignaturasFiltro: asignatura[] = [];

  constructor(
    private rutaActiva: ActivatedRoute,
    private asignaturaServicio: AsignaturasService
  ) {}

  ngOnInit(): void {
    //this.curso = this.rutaActiva.snapshot.params['curso'];
    //console.log(this.rutaActiva.snapshot.params['curso']);
    this.rutaActiva.params.subscribe((params: Params) => {
      this.curso = params['curso'];
      this.asignaturasFiltro = this.asignaturaServicio.fitrarAsignaturas(
        this.curso
      );
    });
  }

  fitrarAnio(anio: string) {
    //this.curso;
    //anio;
    this.asignaturasFiltro = this.asignaturaServicio.filtrarCompleto(
      this.curso,
      anio
    );
  }

  filtrarAsignaturas(curso: string) {
    /* this.asignaturasFiltro = [];
    for (let index = 0; index < this.asignaturas.length; index++) {
      if (
        this.asignaturas[index].ciclo
          .toLocaleLowerCase()
          .includes(curso.toLocaleLowerCase())
      ) {
        this.asignaturasFiltro.push(this.asignaturas[index]);
      }
    } */
    /* this.asignaturasFiltro = this.asignaturas.filter((item) => {
      return item.ciclo.toString().toLowerCase().includes(curso.toLowerCase());
    }); */
  }
}
