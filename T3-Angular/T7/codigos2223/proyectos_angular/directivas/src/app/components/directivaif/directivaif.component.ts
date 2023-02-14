import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivaif',
  templateUrl: './directivaif.component.html',
  styleUrls: ['./directivaif.component.css'],
})
export class DirectivaifComponent {
  mostrarElemento = false;

  cambiarEstado() {
    this.mostrarElemento = !this.mostrarElemento;
  }

  comprobarEstado(nombres: string) {
    nombres === 'Borja'
      ? (this.mostrarElemento = true)
      : (this.mostrarElemento = false);

    /*     nombres === 'Borja' && (this.mostrarElemento = true);
     */
    /* if (nombres === 'Borja') {
      this.mostrarElemento = true;
    } else {
      this.mostrarElemento = false;
    } */
  }
}
