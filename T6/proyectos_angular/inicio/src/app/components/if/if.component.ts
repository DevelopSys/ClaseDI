import { Component } from '@angular/core';

@Component({
  selector: 'app-if',
  standalone: false,

  templateUrl: './if.component.html',
  styleUrl: './if.component.css',
})
export class IfComponent {
  mostrar = false;
  mostrarElemento() {
    this.mostrar = !this.mostrar;
  }
}
