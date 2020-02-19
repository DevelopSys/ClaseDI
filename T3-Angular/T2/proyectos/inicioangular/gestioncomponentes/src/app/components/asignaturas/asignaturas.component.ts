import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-asignaturas",
  templateUrl: "./asignaturas.component.html",
  styleUrls: ["./asignaturas.component.css"]
})
export class AsignaturasComponent implements OnInit {
  parametro: string;

  constructor(private rutas: ActivatedRoute) {}

  ngOnInit() {
    this.rutas.params.subscribe(param => {
        console.log(param)
    });
    console.log(`Elemento pasado por parámetros ${this.parametro}`);
  }
}
