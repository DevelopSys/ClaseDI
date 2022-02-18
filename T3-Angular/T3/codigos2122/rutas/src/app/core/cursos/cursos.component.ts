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

  curso: string = ""



  filtadas: asignatura[] = [];

  constructor(private gestorRutas: ActivatedRoute, private servicioAsignaturas: AsignaturasService) {}

  ngOnInit(): void {

    this.gestorRutas.params.subscribe((elementos: Params) => {
      this.curso = elementos['ciclo'];
      this.filtadas = this.servicioAsignaturas.getAsignaturasFiltradas(this.curso);
    });

    //this.filtadas = this.servicioAsignaturas.getAllAsignaturas();
  }
}
