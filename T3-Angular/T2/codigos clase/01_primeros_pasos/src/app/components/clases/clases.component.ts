import { Component, OnInit } from '@angular/core';
import { Jugador } from '../../utils/jugador';

@Component({
  selector: 'app-clases',
  templateUrl: './clases.component.html',
  styleUrls: ['./clases.component.css']
})
export class ClasesComponent implements OnInit {


  unJugador;

  constructor() { }

  ngOnInit(): void {
    this.unJugador = new Jugador('Andres Iniesta','Visel Kobe','MID','src/assets/images/iniesta.jpg');
    console.log(this.unJugador.mostrarDatos());
  }

}
