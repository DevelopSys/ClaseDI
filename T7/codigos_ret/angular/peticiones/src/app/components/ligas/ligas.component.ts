import { Component } from '@angular/core';
import { LigasService } from '../../services/ligas.service';

@Component({
  selector: 'app-ligas',
  templateUrl: './ligas.component.html',
  styleUrl: './ligas.component.css',
})
export class LigasComponent {
  constructor(private servicioLigas: LigasService) {
    this.servicioLigas.getAllLigas('France').subscribe((data) => {
      data.countries.forEach((element: any) => {
        console.log(element.strLeague);
      });
    });
  }
}
