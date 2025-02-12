import { Component } from '@angular/core';
import { ApiService } from '../../service/api.service';
import { Post } from '../model/modelos';

@Component({
  selector: 'app-listado',
  standalone: false,
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  listado: Post[] = [];

  constructor(private apiService: ApiService) {
    this.apiService.getAllPost().subscribe((data) => {
      // console.log(data);
      this.listado = data.posts;
    });
    // console.log(apiService.getAllPost());
  }
}
