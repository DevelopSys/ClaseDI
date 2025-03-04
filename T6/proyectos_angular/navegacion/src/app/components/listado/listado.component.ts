import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Post } from '../../model/interfeces';

@Component({
  selector: 'app-listado',
  standalone: false,
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  posts!: Post[];
  constructor(private apiServive: ApiService) {
    apiServive.getAllPost().subscribe((data) => {
      this.posts = data.posts;
    });
  }
}
