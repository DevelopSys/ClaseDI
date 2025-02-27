import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-buscador',
  standalone: false,
  templateUrl: './buscador.component.html',
  styleUrl: './buscador.component.css',
})
export class BuscadorComponent {
  parametro = 'ejemplo';

  constructor(private activated: ActivatedRoute) {
    this.activated.params.subscribe((param) => {
      this.parametro = param['id'];
    });
  }
}
