import { Component } from '@angular/core';

@Component({
  selector: 'app-inicial',
  templateUrl: './inicial.component.html',
  styleUrl: './inicial.component.css',
})
export class InicialComponent {
  estado: string = '';
  prioridad: string = '';

  mostrarDatos(nombre: string, descripcion: string) {
    alert(`Datos recibidos ${nombre} ${descripcion}`);
  }

  cambiarDatos(evento: Event) {
    console.log((evento.target as HTMLSelectElement).value);
  }
}
