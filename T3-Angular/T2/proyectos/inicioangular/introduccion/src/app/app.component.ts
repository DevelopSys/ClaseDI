import { Component, OnInit } from "@angular/core";
import { Tecnologia } from './utils/tecnologia';
import { TecnologiaInt } from "./utils/tecnologia_dos";
import { Asignatura } from './utils/asignatura';
import { DatosCiclosService } from './services/datos-ciclos.service';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {

  title = "introduccion";
  nombre: string = "Borja Martin";
  mostrarTecnologias: boolean = true;
  mostrarCurso: string;
  tecnologias: Tecnologia[];
  asignaturas: Asignatura[];

  constructor(private servicioDatos: DatosCiclosService){
  }

  ngOnInit(): void {
    this.asignaturas = this.servicioDatos.getAllAsignaturas();
    this.tecnologias = this.servicioDatos.getAllTecnologias();
  }


  mandarMensaje(elemento: Tecnologia) {
    console.log(elemento.getDescripcion());
  }

  cambiarTecnologia() {
    console.log(this.mostrarTecnologias);
    this.mostrarTecnologias = !this.mostrarTecnologias;
  }

  cambiarCurso(elemento: string) {
    this.mostrarCurso = elemento;
  }
}
