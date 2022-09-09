import { Component, OnInit } from '@angular/core';
import { ProfesoresService } from 'src/app/services/profesores.service';

@Component({
  selector: 'rutas-conexion',
  templateUrl: './conexion.component.html',
  styleUrls: ['./conexion.component.css'],
})
export class ConexionComponent implements OnInit {
  profesores: any[] = [];

  constructor(private servicioProfesores: ProfesoresService) {}

  ngOnInit(): void {
    this.servicioProfesores.getAllProfesores().subscribe((d) => {
      //console.log(d.results);
      this.profesores = d.results;
      //console.log(this.profesores);
    });
  }

  pulsacionBotonNumero(numero: string, genero: string) {
    if (!isNaN(Number(numero))) {
      /* this.servicioProfesores
        .getProfesoresResults(Number(numero))
        .subscribe((d) => {
          this.profesores = d.results;
        }); */

      this.servicioProfesores
        .getProfesoresFiltro(Number(numero), genero)
        .subscribe((d) => {
          this.profesores = d.results;
        });
    }
  }
}
