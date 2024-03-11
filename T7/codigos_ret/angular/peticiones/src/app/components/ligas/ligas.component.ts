import { Component } from '@angular/core';
import { LigasService } from '../../services/ligas.service';

@Component({
  selector: 'app-ligas',
  templateUrl: './ligas.component.html',
  styleUrl: './ligas.component.css',
})
export class LigasComponent {
  pais = 'Italy';
  listaLigas: any[] = [];
  constructor(private servicioLigas: LigasService) {
    this.consultaLigas();
  }

  consultaLigas() {
    this.servicioLigas.getAllLigas(this.pais).subscribe((data) => {
      this.listaLigas = data.countries;
    });
  }
}
