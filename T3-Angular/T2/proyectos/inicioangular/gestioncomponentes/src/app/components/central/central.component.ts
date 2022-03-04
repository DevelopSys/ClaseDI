import { Component, OnInit } from '@angular/core';
import { DatosService } from '../../services/datos.service';

@Component({
  selector: 'app-central',
  templateUrl: './central.component.html',
  styleUrls: ['./central.component.css']
})
export class CentralComponent implements OnInit {

  miArray: string[];

  constructor(private servicio: DatosService) { }

  ngOnInit() {
    this.miArray = this.servicio.getArrayUno();
  }

}
