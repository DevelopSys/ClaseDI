import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'rutas-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent implements OnInit {
  asignaturas = [
    { nombre: 'PMDM', profesor: 'BMH', hora: 5, curso: 'dam' },
    { nombre: 'DI', profesor: 'BMH', hora: 5, curso: 'dam' },
    { nombre: 'SI', profesor: 'IS', hora: 5, curso: 'dam|daw' },
    { nombre: 'BD', profesor: 'JG', hora: 5, curso: 'dam|daw' },
    { nombre: 'ED', profesor: 'JN', hora: 5, curso: 'dam|daw' },
    { nombre: 'PSP', profesor: 'JN', hora: 5, curso: 'dam' },
    { nombre: 'Ing', profesor: 'RP', hora: 5, curso: 'dam|daw' },
    { nombre: 'EIE', profesor: 'MV', hora: 5, curso: 'dam|daw' },
    { nombre: 'DAWC', profesor: 'BMH', hora: 5, curso: 'daw' },
    { nombre: 'DAWS', profesor: 'IS', hora: 5, curso: 'daw' },
    { nombre: 'DI', profesor: 'JG', hora: 5, curso: 'daw' },
    { nombre: 'DAW', profesor: 'JN', hora: 5, curso: 'daw' },
    { nombre: 'DP', profesor: 'BM', hora: 5, curso: 'bd' },
    { nombre: 'AD', profesor: 'DC', hora: 5, curso: 'bd' },
    { nombre: 'PD', profesor: 'AF', hora: 5, curso: 'bd' },
    { nombre: 'AWS', profesor: 'CA', hora: 5, curso: 'bd' },
  ];

  filtadas = [{ nombre: 'PMDM', profesor: 'BMH', hora: 5, curso: 'dam' }];

  constructor(private gestorRutas: ActivatedRoute) {}

  ngOnInit(): void {
    //console.log(this.gestorRutas.snapshot.params['ciclo'])
    this.gestorRutas.params.subscribe((elementos: Params) => {
      let curso = elementos['ciclo'];
      this.filtadas = this.asignaturas.filter((e) => {
        return e.curso.includes(curso);
      });
    });
  }
}
