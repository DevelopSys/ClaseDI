import { Component } from '@angular/core';

@Component({
  selector: 'directivas-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css'],
})
export class EventosComponent {
  alumno = {
    nombre: '',
    apellido: '',
    ciclo: '',
    experiencia: '',
    estudios: '',
  };

  estudios = '';

  urlImagen =
    'https://digital55.com/wp-content/uploads/2022/01/Renderizado_en_servidor_con_angular_universal.png';

  /* pulsacionBotonIncial(nombre: string) {
    //console.log(`Nombre pasado: ${nombre}, edad pasada ${edad}`);
    this.alumno.nombre = nombre;
    console.log(nombre);
  } */

  capturaCambioRadio(estudios: string) {
    // console.log(`Radio cambiado con valor ${estudios}}`);
    this.estudios = estudios;
  }

  capturaValores(nombre: string, apellido: string, ciclo: string) {
    this.alumno.nombre = nombre;
    this.alumno.apellido = apellido;
    this.alumno.ciclo = ciclo;
    this.alumno.estudios = this.estudios;
  }
}
