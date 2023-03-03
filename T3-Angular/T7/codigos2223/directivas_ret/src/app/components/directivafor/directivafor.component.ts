import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivafor',
  templateUrl: './directivafor.component.html',
  styleUrls: ['./directivafor.component.css'],
})
export class DirectivaforComponent {
  filtrando = false;

  coleccionElementos: string[] = [
    'Elemento 1',
    'Elemento 2',
    'Elemento 3',
    'Elemento 4',
    'Elemento 5',
    'Elemento 6',
    'Elemento 7',
    'Elemento 3',
    'Elemento 3',
    'Elemento 3',
    'Elemento 4',
    'Elemento 1',
  ];

  coleccionElementosFiltrados: string[] = [];

  agregarLI(valor: string) {
    this.coleccionElementos.unshift(valor);
  }

  filtrarElementos(valor: string) {
    let numero = Number(valor);
    if (isNaN(numero)) {
      alert('Por favor introduce un numero');
    } else {
      this.filtrando = true;
      this.coleccionElementosFiltrados = this.coleccionElementos.filter(
        (item) => item.includes(numero.toString())
      );
      /* this.coleccionElementosFiltrados = [];
      this.coleccionElementos.forEach((item) => {
        if (item.includes(numero.toString())) {
          this.coleccionElementosFiltrados.push(item);
        }
      }); */
    }
  }
}
