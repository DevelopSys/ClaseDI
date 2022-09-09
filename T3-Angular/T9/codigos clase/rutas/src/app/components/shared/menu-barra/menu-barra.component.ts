import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-barra',
  templateUrl: './menu-barra.component.html',
  styleUrls: ['./menu-barra.component.css'],
})
export class MenuBarraComponent implements OnInit {
  constructor(private navegador: Router) {}

  ngOnInit(): void {}

  navegar() {
    this.navegador.navigate(['libros']);
  }

  navegarParametros(parametro?) {
    if (parametro) {
      this.navegador.navigate(['videojuegos', parametro]);
    } else {
      this.navegador.navigate(['videojuegos']);
    }
  }
}
