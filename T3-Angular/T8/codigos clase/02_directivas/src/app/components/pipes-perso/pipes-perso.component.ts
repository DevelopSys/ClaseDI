import { Component, OnInit } from '@angular/core';
import { Ciudad } from '../../utils/Ciudad';

@Component({
  selector: 'app-pipes-perso',
  templateUrl: './pipes-perso.component.html',
  styleUrls: ['./pipes-perso.component.css'],
})
export class PipesPersoComponent implements OnInit {
  ciudades: Ciudad[];

  constructor() {}

  ngOnInit(): void {
    this.ciudades = [
      {
        nombre: 'NEW YORK',
        imagen: 'assets/images/new_york.jpg',
      },
      {
        nombre: 'SAN FRANCISCO',
        imagen: 'assets/images/san_francisco.jpg',
      },
      {
        nombre: 'MADRID',
        imagen: 'assets/images/madrid.jpg',
      },
      { nombre: 'BARCELONA', imagen: '' },
      { nombre: 'BARCELONA', imagen: '' }
    ];
  }
}
