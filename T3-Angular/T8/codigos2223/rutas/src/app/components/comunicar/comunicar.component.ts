import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'rutas-comunicar',
  templateUrl: './comunicar.component.html',
  styleUrls: ['./comunicar.component.css'],
})
export class ComunicarComponent {
  datoComunicado = '';

  // capturar el parametro --> ActivatedRoute

  constructor(private gestorRutas: ActivatedRoute) {
    gestorRutas.params.subscribe((param: Params) => {
      this.datoComunicado = param['id'];
    });
  }
}
