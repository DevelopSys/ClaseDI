import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'rutas-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent implements OnInit {
  curso: string = 'DAM';

  asignaturas = [
    {
      asignatura: 'Programacion multimedia',
      siglas: 'PMDM',
      horas: 4,
      profesor: 'Borja Martin',
      ciclo: 'DAM',
      curso: 2,
      conocimientos: ['Java', 'XML', 'JSON', 'Android'],
    },
    {
      asignatura: 'Desarrollo interfaces',
      siglas: 'DI',
      horas: 6,
      profesor: 'Borja Martin',
      ciclo: 'DAM',
      curso: 2,
      conocimientos: ['Java', 'JavaScript', 'Typescript', 'JSON'],
    },
    {
      asignatura: 'Sistemas informaticos',
      siglas: 'SI',
      horas: 6,
      profesor: 'Alfonso',
      ciclo: 'DAM|DAW',
      curso: 1,
      conocimientos: ['Sistemas', 'Hardware', 'Servidores', 'SO'],
    },
    {
      asignatura: 'Base de datos',
      siglas: 'BD',
      horas: 6,
      profesor: 'Fernando Sanchez',
      ciclo: 'DAM|DAW',
      curso: 1,
      conocimientos: ['Base dato', 'MySQL', 'Oracle'],
    },
    {
      asignatura: 'Desarrollo cliente',
      siglas: 'DC',
      horas: 6,
      profesor: 'Borja Martin',
      ciclo: 'DAW',
      curso: 2,
      conocimientos: ['JavaScript', 'React', 'NODE'],
    },
    {
      asignatura: 'Desarrollo servidor',
      siglas: 'DW',
      horas: 6,
      profesor: 'Borja Martin',
      ciclo: 'DAW',
      curso: 2,
      conocimientos: ['PHP', 'Django'],
    },
  ];

  asignaturasFiltro: any[] = [];

  constructor(private rutaActiva: ActivatedRoute) {}

  ngOnInit(): void {
    //this.curso = this.rutaActiva.snapshot.params['curso'];
    //console.log(this.rutaActiva.snapshot.params['curso']);
    this.rutaActiva.params.subscribe((params: Params) => {
      this.curso = params['curso'];
      this.filtrarAsignaturas(this.curso);
    });
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

    this.asignaturasFiltro = this.asignaturas.filter((item) => {
      return item.ciclo.toString().toLowerCase().includes(curso.toLowerCase());
    });
  }
}
