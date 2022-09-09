import { Component, OnInit, DoCheck } from '@angular/core';

@Component({
  selector: 'app-directivas',
  templateUrl: './directivas.component.html',
  styleUrls: ['./directivas.component.css']
})
export class DirectivasComponent implements OnInit{


  nombre: string;
  directivaif: string;
  directivasw: string;
  elementos: string[];
  elemento: string;
  clases = ['paquenia','mediana','grande'];
  grandeCh: boolean;
  medianaCh: boolean;
  pequeniaCh: boolean;

  constructor() {
    this.directivaif ="";
    this.elementos = new Array();
  }

  ngOnInit(): void {
  }

  agregarElemento(){
    this.elementos.push(this.elemento);
    this.elemento = '';
  }

  
}
