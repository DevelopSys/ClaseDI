import { Component, OnInit } from '@angular/core';
import { Jugador } from '../../utils/jugador';
import { JugadorInterfaz } from '../../utils/jugador-interfaz';

@Component({
  selector: 'app-clases',
  templateUrl: './clases.component.html',
  styleUrls: ['./clases.component.css'],
})
export class ClasesComponent implements OnInit {
  unJugador;
  unJugadorInterfaz: JugadorInterfaz;

  constructor() {}

  ngOnInit(): void {
    this.unJugador = new Jugador(
      'Andres Iniesta',
      'Visel Kobe',
      'MID',
      'src/assets/images/iniesta.jpg'
    );
    this.unJugadorInterfaz = {
      nombre: 'Eric Cantona',
      equipo: 'Manchester United',
      posicion: 'DEL',
      imagen: 'src/assets/images/cantona.jpg',
      mostrarDatos: () => {
        console.log('mostrar los datos');
      }
    };
  }
}
