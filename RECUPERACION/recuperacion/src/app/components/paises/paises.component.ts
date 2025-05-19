import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Countrie } from '../../model/modelos';

@Component({
  selector: 'app-paises',
  imports: [CommonModule],
  templateUrl: './paises.component.html',
  styleUrl: './paises.component.css',
})
export class PaisesComponent {
  paises: Countrie[] = [];

  constructor(private api: ApiService) {
    this.api.getAllCountries().subscribe((data) => {
      this.paises = data;
    });
  }
}
