import { Component, OnInit } from '@angular/core';
import { FutbolDataService } from '../../services/futbol-data.service';
import { Liga } from '../../utils/ligas';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-futbol',
  templateUrl: './futbol.component.html',
  styleUrls: ['./futbol.component.css'],
})
export class FutbolComponent implements OnInit {
  ligas: Liga[];
  ligasServicio: [];
  id;

  constructor(
    private servicioFutbol: FutbolDataService,
    private rutaActiva: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.rutaActiva.paramMap.subscribe((paramentros: ParamMap) => {
      this.id = paramentros.get('id');
    });

    //console.log(this.id);

    if (this.id) {
      this.ligas = this.servicioFutbol.getLiga(this.id);
    } else {
      this.ligas = this.servicioFutbol.getLigas();
      //console.log(this.ligas);
      this.servicioFutbol.getLigasAPIFiltrado().subscribe((elementos)=>{this.ligasServicio = elementos});
      //this.servicioFutbol.getLigasAPI().subscribe((elementos)=>{this.ligasServicio = elementos['leagues']});
    }
    //this.servicioFutbol.getLigasAPI().subscribe((elementos)=>{console.log(elementos);});
    //this.servicioFutbol.getLigasAPIFiltrado().subscribe((elementos)=>{console.log(elementos);});
  }
}
