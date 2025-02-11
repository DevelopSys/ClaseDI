import { Component } from '@angular/core';
import { ApiService } from '../../service/api.service';

@Component({
  selector: 'app-listado',
  standalone: false,
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  constructor(private apiService: ApiService) {
    this.apiService.getAllPost().subscribe((data) => {
      console.log(data);
    });

    // console.log(apiService.getAllPost());
  }
}
