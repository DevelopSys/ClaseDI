import { Component } from '@angular/core';

@Component({
  selector: 'app-switch',
  standalone: false,

  templateUrl: './switch.component.html',
  styleUrl: './switch.component.css',
})
export class SwitchComponent {
  valor = 0;

  cambiarSeleccion($event: Event) {
    let seleccion = ($event.target as HTMLInputElement).value;
    this.valor = Number(seleccion);
  }

  cambioSeleccionDos(seleccion: string) {
    this.valor = Number(seleccion);
  }
}
