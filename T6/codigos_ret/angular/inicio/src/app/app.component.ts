import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  nombre: string = 'Borja Martin Herrera';
  imagen =
    'https://assets-global.website-files.com/6344c9cef89d6f2270a38908/637e4996c01e73a01e090413_c2.webp';
  title = 'inicio';
}
