import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-motos',
  templateUrl: './motos.component.html',
  styleUrl: './motos.component.css',
})
export class MotosComponent {
  /* necesito el modulo ActivatedRoute */
  tipoMoto: string | undefined;

  constructor(private rutaActiva: ActivatedRoute) {
    //console.log(this.rutaActiva.snapshot.params['tipo']);
    rutaActiva.paramMap.subscribe((item: ParamMap) => {
      this.tipoMoto = item.get('tipo')?.toString();
    });
  }
}
