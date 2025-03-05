import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../../services/api.service';
import { Post } from '../../model/interfeces';
import { log } from 'console';

@Component({
  selector: 'app-buscador',
  standalone: false,
  templateUrl: './buscador.component.html',
  styleUrl: './buscador.component.css',
})
export class BuscadorComponent {
  parametro = 'ejemplo';
  tag = '';
  posts!: Post[];

  constructor(private service: ApiService) {}

  consultarTag() {
    //
    // console.log(this.service.getAllPostByTag('history'));

    this.service.getAllPostByTag(this.tag).subscribe((data) => {
      this.posts = data.posts;
    });
  }
}
