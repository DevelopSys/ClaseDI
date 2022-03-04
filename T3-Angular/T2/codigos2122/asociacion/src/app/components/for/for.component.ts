import { isNgTemplate } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'asociacion-for',
  templateUrl: './for.component.html',
  styleUrls: ['./for.component.css'],
})
export class ForComponent implements OnInit {

 numeroAsignturas: number = 1;

  asignaturas: any[] = [
    {
      imagen:
        'https://www.muycomputer.com/wp-content/uploads/2019/12/android-1000x600.jpg',
      nombre: 'Programación Multimedia',
      siglas: 'PMDM',
      profesor: 'Borja Martin ',
      horas: 5,
      conocimientos: ['Java', 'Android', 'Programacion', 'JSON'],
      curso: 'DAM2',
    },
    {
      imagen:
        'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Anjuta-2.0.0-2.png/500px-Anjuta-2.0.0-2.png',
      nombre: 'Entornos',
      siglas: 'ED',
      profesor: 'Jesus Niño ',
      horas: 4,
      conocimientos: ['Diagramas', 'Metodologias'],
      curso: 'DAM1',
    },
    {
      imagen: undefined,
      nombre: 'Base de datos',
      siglas: 'BD',
      profesor: 'Javier García',
      horas: 5,
      conocimientos: ['Relaciones', 'MySQL'],
      curso: 'DAM1',
    },
    {
      imagen: '',
      nombre: 'Acceso a datos',
      siglas: 'AD',
      profesor: 'Ruben Juarez',
      horas: 6,
      conocimientos: ['Datos', 'Accesos a colecciones'],
      curso: 'DAM2',
    },
    {
      imagen: '',
      nombre: 'Sistemas',
      siglas: 'SI',
      profesor: 'Isaac Sampedro',
      horas: 6,
      conocimientos: ['Windows', 'Linux', 'Redes'],
      curso: 'DAM1',
    },
    {
      imagen: '',
      nombre: 'Formacion y Orientación',
      siglas: 'FOL',
      profesor: 'Ivan Redruello',
      horas: 3,
      conocimientos: ['Contratos','Nominas','Legislacion'],
      curso: 'DAM1',
    },
    {
      imagen: '',
      nombre: 'Desarrollo de Interfaces',
      siglas: 'DI',
      profesor: 'Borja Martin',
      horas: 5,
      conocimientos: ['Java','JavaScript'],
      curso: 'DAM2',
    }
  ];

  elementos: string[] = [
    'Elemento 1',
    'Elemento 2',
    'Elemento 3',
    'Elemento 4',
    'Elemento 5',
    'Elemento 6',
  ];

  asignaturasFiltradas: any[] = [];

  constructor() {
    //this.arrayCurso("DAM2")
    this.asignaturasFiltradas = this.asignaturas;
    this.numeroAsignturas = this.asignaturasFiltradas.length
  }

  ngOnInit(): void {}

  metodoFiltrar(curso: string, numero: string) {


    //curso.toLowerCase() == item.toLowerCase();
    this.asignaturasFiltradas = this.arrayCurso(curso, Number(numero))
    this.numeroAsignturas = this.asignaturasFiltradas.length
  }

  arrayCurso(curso: string, numero: number): any[] {
    /*this.asignaturas.forEach(element => {
        if (element.curso == curso){
          this.asignaturasFiltradas.push(element)
        }
      });*/


      if (curso == "todas"){
        this.asignaturasFiltradas = this.asignaturas.filter(e=> e.horas >= numero);
        return this.asignaturasFiltradas;
      }
      else {
        this.asignaturasFiltradas = this.asignaturas.filter(
          (element) => element.curso == curso && element.horas >=numero
        );

        return this.asignaturasFiltradas;
      }


  }
}
