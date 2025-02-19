import { Component } from '@angular/core';
import { ApiService } from '../../service/api.service';
import { Post } from '../../model/modelos';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listado',
  standalone: false,
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  listado: Post[] = [];
  mostrar = true;

  constructor(private apiService: ApiService, private router: Router) {
    this.apiService.getAllPost().subscribe((data) => {
      // console.log(data);
      this.listado = data.posts;
    });
    this.apiService.getAllTags().subscribe((data) => {
      console.log(data);
    });
    // console.log(apiService.getAllPost());
  }
}
