import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { DatosService } from '../../services/datos.service';

@Component({
  selector: "app-asignaturas",
  templateUrl: "./asignaturas.component.html",
  styleUrls: ["./asignaturas.component.css"]
})
export class AsignaturasComponent implements OnInit {
  
  parametro: string;
  miArray: string[];
  constructor(private rutas: ActivatedRoute, private servicio: DatosService) {}

  ngOnInit() {
    this.rutas.params.subscribe(loquesea => {
        this.parametro = loquesea.parametro;

    });
    console.log(`El contenido de la variable pasada es ${this.parametro}`);

    this.miArray = this.servicio.getArrayDos();
  }
}
