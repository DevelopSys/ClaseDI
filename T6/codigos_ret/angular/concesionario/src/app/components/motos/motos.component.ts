import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Vehiculo } from '../../model/coche';

@Component({
  selector: 'app-motos',
  templateUrl: './motos.component.html',
  styleUrl: './motos.component.css',
})
export class MotosComponent {
  /* necesito el modulo ActivatedRoute */
  tipoMoto: string | undefined;
  motos: Vehiculo[] = [
    new Vehiculo('ford', 'CRV', '1234A', 200, 2000, 20000, '', [], 'venta'),
    new Vehiculo('Yamaha', 'R200', '1234B', 200, 2000, 20000, '', [], 'venta'),
    new Vehiculo(
      'audi',
      'City',
      '1234B',
      200,
      2000,
      20000,
      '',
      [],
      'competicion'
    ),
    new Vehiculo('Peugeut', 'C400', '1234B', 200, 2000, 20000, '', [], 'venta'),
  ];
  motosFiltadas: Vehiculo[] = [];

  constructor(private rutaActiva: ActivatedRoute) {
    //console.log(this.rutaActiva.snapshot.params['tipo']);
    rutaActiva.paramMap.subscribe((item: ParamMap) => {
      this.tipoMoto = item.get('tipo')?.toString();
      this.motosFiltadas = this.motos.filter((item: Vehiculo) => {
        return item.getTipo == this.tipoMoto;
      });
    });
  }
}
