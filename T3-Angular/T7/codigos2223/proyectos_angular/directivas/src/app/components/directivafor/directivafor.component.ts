import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivafor',
  templateUrl: './directivafor.component.html',
  styleUrls: ['./directivafor.component.css'],
})
export class DirectivaforComponent {
  elementos: string[] = ['Elemento1', 'Elemento2', 'Elemento3'];

  asignaturas: any[] = [
    {
      nombre: 'Programacion multimedia',
      siglas: 'PMDM',
      curso: 2,
      ciclo: 'DAM',
      imagen:
        'https://www.adslzone.net/app/uploads-adslzone.net/2019/12/android-malware-apps.jpg?x=480&y=375&quality=40',
      profesor: 'Borja Martin',
      conocimientos: ['Kotlin', 'xml', 'java'],
    },
  ];

  anadirElemento(dato: string) {
    this.elementos.push(dato);
  }
}
