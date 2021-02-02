import { TecnologiaInterfaz } from './../../utils/TecnologiaInterfaz';
import { Tecnologia } from './../../utils/Tecnologia';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-materia',
  templateUrl: './materia.component.html',
  styleUrls: ['./materia.component.css'],
})
export class MateriaComponent implements OnInit {


  tecnoInterfaz: TecnologiaInterfaz = { nombre:"texIf",imagen:"asdasd", descripcion:"asdasda"}

  tecnologiaObj = new Tecnologia("Angular","Descripcion Angular","foto angular");

  nombreTec: string = this.tecnologiaObj.nombre

  angular = {
    nombre: 'Angular 11.0',
    descripcion: 'Framework JS para la creación de aplicaciones de tipo SPA',
    imagen: 'assets/images/angular.png',
  };
  
  java = {
    nombre: 'Java',
    descripcion: 'Lenguaje de programación multiplataforma',
    //imagen: 'assets/images/java.png',
  };
  
  js = {
    nombre: 'JavaScript',
    descripcion: 'Lenguaje de programación web interpretado por el navegador',
    imagen: 'assets/images/js.jpg',
  };
  pw = {
    nombre: 'Powershell',
    descripcion: 'Lenguaje de programación orientado a segudidad y automatización',
    imagen: 'assets/images/powershell.png',
  };
  python = {
    nombre: 'Python',
    descripcion: 'Lenguaje de multiplataforma destinado al lado del servidor',
    imagen: 'assets/images/python.jpg',
  };
  mysql = {
    nombre: 'MySQL',
    descripcion: 'Lenguaje de creación y gestión de base de datos',
    imagen: 'assets/images/mysql.jpg',
  };
  xml = {
    nombre: 'XML',
    descripcion: 'Lenguaje de marcado para el intercambio de datos',
    imagen: 'assets/images/xml.jpg',
  };
  html = {
    nombre: 'HTML',
    descripcion: 'Lenguaje de marcado destinado a la creción de webs estáticas',
    imagen: 'assets/images/html.jpeg',
  };
  tecnologias: any[] = [this.angular, this.html, this.js, this.pw, this.python,this.java,this.xml]
  
  tecnologiasArray: Tecnologia[] = [];

  /*imagen = "assets/images/angular.png"
  nombre = "Angular 11.0"
  descripcion = "Framework JS para la creación de aplicaciones de tipo SPA"*/

  constructor() {}

  ngOnInit(): void {}
}
