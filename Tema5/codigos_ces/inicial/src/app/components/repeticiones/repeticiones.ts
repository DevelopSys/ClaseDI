import { Component } from '@angular/core';

@Component({
  selector: 'app-repeticiones',
  standalone: false,
  templateUrl: './repeticiones.html',
  styleUrl: './repeticiones.css',
})
export class Repeticiones {
  usuarios: string[] = ['Borja', 'Maria', 'Juan', 'Marta', 'Pedro', 'Celia', 'Claudia'];
  nombreIntroducido: string = '';

  agregarUsuario() {
    throw new Error('Method not implemented.');
  }
}
