import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-materia',
  templateUrl: './materia.component.html',
  styleUrls: ['./materia.component.css']
})
export class MateriaComponent implements OnInit {

  angular = {nombre:"Angular 11.0", 
  descripcion: "Framework JS para la creación de aplicaciones de tipo SPA", 
  imagen:"assets/images/angular.png" ,}

  /*imagen = "assets/images/angular.png"
  nombre = "Angular 11.0"
  descripcion = "Framework JS para la creación de aplicaciones de tipo SPA"*/

  constructor() { }

  ngOnInit(): void {
  }

}
