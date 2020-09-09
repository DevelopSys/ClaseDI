import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css'],
})
export class JuegosComponent implements OnInit {
  constructor(private rutaActiva: ActivatedRoute) {}

  ngOnInit(): void {
    //console.log(this.rutaActiva.snapshot.paramMap.params['id']);
    
    this.rutaActiva.paramMap.subscribe((parametros: Params) => {
      console.log(parametros.id);
    });
  }
}
