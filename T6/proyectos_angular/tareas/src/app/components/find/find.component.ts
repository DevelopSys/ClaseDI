import { Component } from '@angular/core';

@Component({
  selector: 'app-find',
  standalone: false,
  templateUrl: './find.component.html',
  styleUrl: './find.component.css',
})
export class FindComponent {
  buscar = false;

  realizarBusqueda($event: Event) {
    if (($event.target as HTMLInputElement).value != 'todas') {
      this.buscar = true;
    } else {
      this.buscar = false;
    }
  }
}
