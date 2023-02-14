import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivaswitch',
  templateUrl: './directivaswitch.component.html',
  styleUrls: ['./directivaswitch.component.css'],
})
export class DirectivaswitchComponent {
  opcion = 1;

  cambioOpcion(evento: any) {
    this.opcion = evento.target.value;
  }
}
