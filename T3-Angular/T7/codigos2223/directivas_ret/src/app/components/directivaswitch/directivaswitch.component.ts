import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivaswitch',
  templateUrl: './directivaswitch.component.html',
  styleUrls: ['./directivaswitch.component.css'],
})
export class DirectivaswitchComponent {
  seleccion = -1;

  cambioRadio(evento: any) {
    this.seleccion = Number(evento.target.value);
  }
}
