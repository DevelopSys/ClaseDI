import { Component } from '@angular/core';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrl: './contacto.component.css',
})
export class ContactoComponent {
  seleccionSelect = '-1';

  modificarSeleccion(seleccion: string) {
    this.seleccionSelect = seleccion;
  }
}
