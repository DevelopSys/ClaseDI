import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes-comp',
  templateUrl: './pipes-comp.component.html',
  styleUrls: ['./pipes-comp.component.css'],
})
export class PipesCompComponent implements OnInit {
  textToUpper: string = 'ESPERANDO ALGO';
  textToLower: string = 'ESPERANDO ALGO';

  constructor() {}

  ngOnInit(): void {}

  capturarLower(elemento) {
    console.log('pulsa');

    if (elemento.length > 0) {
      this.textToLower = elemento;
    }
  }
  capturarUpper(elemento) {
    if (elemento.length > 0) {
      this.textToUpper = elemento;
    }
  }
}
