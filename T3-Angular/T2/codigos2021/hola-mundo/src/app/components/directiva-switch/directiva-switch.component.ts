import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva-switch',
  templateUrl: './directiva-switch.component.html',
  styleUrls: ['./directiva-switch.component.css'],
})
export class DirectivaSwitchComponent implements OnInit {
  valorInput: number = 0;

  constructor() {}

  ngOnInit(): void {}

  cambiarValorInput(valor: number) {
    this.valorInput = valor;
  }

  mostrarPulsacion(valor:any){
    console.log("pulsado boton");
    console.log(valor);
    this.valorInput = valor;
    
    
  }

  mostrarDatos(evento: Event) {
    //console.log(evento.target.value);
  }
}
