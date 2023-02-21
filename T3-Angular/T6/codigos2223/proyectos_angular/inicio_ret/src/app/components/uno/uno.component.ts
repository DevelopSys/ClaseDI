import { Component } from '@angular/core';

@Component({
  selector: 'app-uno',
  templateUrl: './uno.component.html',
  styleUrls: ['./uno.component.css'],
})
export class UnoComponent {
  contador: number = 0;
  base: number = 0;
  setearBase(base: Event) {
    console.log(base);

    console.log(`Cambio realizado ${base}`);

    this.base = Number(base);
  }

  realizarOperacion(opcion: number) {
    switch (opcion) {
      case 1:
        this.contador++;
        break;
      case 2:
        this.contador--;
        break;
      case 3:
        this.base != 0 ? (this.contador = this.base) : (this.contador = 0);
        break;
    }
  }

  realizarIncremento() {
    console.log('Realizada pulsacion');
    this.contador++;
  }
  realizarDecremento() {
    console.log('Realizada pulsacion');
    this.contador--;
  }
  realizarReseteo() {
    console.log('Realizada pulsacion');
    this.contador = 0;
  }
}
