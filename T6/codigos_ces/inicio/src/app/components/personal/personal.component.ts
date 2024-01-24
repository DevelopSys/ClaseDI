import { Component } from '@angular/core';

@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrl: './personal.component.css',
})
export class PersonalComponent {
  imagenPerfil: String =
    'https://cdn-icons-png.flaticon.com/256/1864/1864509.png';

  textoBoton = 'Mostrar';
  mostrarContenido = false;

  pulsacionBoton() {
    if (this.mostrarContenido) {
      this.textoBoton = 'Ocultar';
      this.mostrarContenido = false;
    } else {
      this.textoBoton = 'Mostrar';
      this.mostrarContenido = true;
    }
    /* this.mostrarContenido
      ? (this.textoBoton = 'Ocultar')
      : (this.textoBoton = 'Mostrar'); */
  }
}
