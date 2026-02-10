import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-buscar',
  standalone: false,
  templateUrl: './buscar.html',
  styleUrl: './buscar.css',
})
export class Buscar {
  prioridad?: string;

  constructor(private gestorRutasActivas: ActivatedRoute) {
    // this.prioridad = gestorRutasActivas.snapshot.params['id'];
    this.gestorRutasActivas.paramMap.subscribe((item) => {
      this.prioridad = item.get('id') ?? undefined;
    });
  }
}
