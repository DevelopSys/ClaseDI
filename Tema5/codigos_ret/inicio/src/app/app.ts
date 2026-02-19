import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { RouterOutlet, RouterLinkWithHref, ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [FormsModule, RouterOutlet, RouterLinkWithHref, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  constructor(private gestorRutas: Router) {}

  navegar(param: string) {
    this.gestorRutas.navigate(['tareas', param]);
  }
}
