import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-materia',
  templateUrl: './materia.component.html',
  styleUrls: ['./materia.component.css'],
})
export class MateriaComponent implements OnInit {
  angular = {
    nombre: 'Angular 11.0',
    descripcion: 'Framework JS para la creación de aplicaciones de tipo SPA',
    imagen: 'assets/images/angular.png',
  };

  java = {
    nombre: 'Java',
    descripcion: 'Lenguaje de programación multiplataforma',
    imagen: 'assets/images/java.png',
  };

  js = {
    nombre: 'JavaScript',
    descripcion: 'Lenguaje de programación web interpretado por el navegador',
    imagen: 'assets/images/js.jpg',
  };

  /*imagen = "assets/images/angular.png"
  nombre = "Angular 11.0"
  descripcion = "Framework JS para la creación de aplicaciones de tipo SPA"*/

  constructor() {}

  ngOnInit(): void {}
}
