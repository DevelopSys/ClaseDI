import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'rutas-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent implements OnInit {
  constructor(private gestorRutas: ActivatedRoute) {}

  ngOnInit(): void {
    //console.log(this.gestorRutas.snapshot.params['ciclo'])
    this.gestorRutas.params.subscribe((elementos: Params) => {
      console.log(elementos['ciclo']);

    });
  }
}
