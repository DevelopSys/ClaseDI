import { Component } from '@angular/core';

@Component({
  selector: 'directivas-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css'],
})
export class EventosComponent {
  alumno = {
    nombre: 'Borja',
    apellido: 'Martin',
    edad: 38,
  };

  urlImagen =
    'https://digital55.com/wp-content/uploads/2022/01/Renderizado_en_servidor_con_angular_universal.png';

  pulsacionBotonIncial(nombre: string, edad: Number) {
    //console.log(`Nombre pasado: ${nombre}, edad pasada ${edad}`);
    this.alumno.nombre = nombre;
  }
}
