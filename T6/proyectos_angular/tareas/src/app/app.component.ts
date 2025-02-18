import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'tareas';
  seleccion = '1';

  realizarCambio($event: Event) {
    this.seleccion = ($event.target as HTMLInputElement).value;
  }
}
