import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'curso';
  // router -> angular
  constructor(private router: Router) {}

  navegar() {
    this.router.navigate(['buscador']);
  }
}
