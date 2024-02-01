import { Component } from '@angular/core';

@Component({
  selector: 'app-secundario',
  templateUrl: './secundario.component.html',
  styleUrl: './secundario.component.css',
})
export class SecundarioComponent {
  mostrar: boolean = true;
  textoElementoMostrado = 2;

  cambiarElemento() {
    this.mostrar = !this.mostrar;
    this.textoElementoMostrado == 1
      ? (this.textoElementoMostrado = 2)
      : (this.textoElementoMostrado = 1);
  }
}
