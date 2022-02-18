import { Component, OnInit } from '@angular/core';
import { ProfesoresService } from 'src/app/services/profesores.service';

@Component({
  selector: 'rutas-conexion',
  templateUrl: './conexion.component.html',
  styleUrls: ['./conexion.component.css']
})
export class ConexionComponent implements OnInit {

  constructor(private servicioProfesores: ProfesoresService) { }

  ngOnInit(): void {
    this.servicioProfesores.getAllProfesores().subscribe(d=>console.log(d.results));

  }

}
