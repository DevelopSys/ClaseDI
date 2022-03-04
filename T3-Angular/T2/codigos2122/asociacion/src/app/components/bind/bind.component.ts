import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'asociacion-bind',
  templateUrl: './bind.component.html',
  styleUrls: ['./bind.component.css'],
})
export class BindComponent implements OnInit {
  nombre: string = 'Borja Martin Herrera';
  edad: number = 20;
  numero1: number = 5;
  numero2: number = 10;
  dni: string = "123ASD"
  imagen = 'https://i.blogs.es/a19bfc/testing/450_1000.jpg';

  botonPulsado() {
    alert('boton pulsado correctemente')
    this.nombre = 'Nuevo nombre';
  }

  calcularSuma(numeroUno: number, numeroDos: number): number{
    if (numeroUno != undefined && numeroDos != undefined){
      return numeroUno + numeroDos;
    } else {
      return 0;
    }

  }

  constructor() {}

  ngOnInit(): void {}
}
