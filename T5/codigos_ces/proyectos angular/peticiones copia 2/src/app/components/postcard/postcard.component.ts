import { Component, Input } from '@angular/core';
import { Post } from '../../model/modelos';
import { Router } from '@angular/router';

@Component({
  selector: 'app-postcard',
  standalone: false,
  templateUrl: './postcard.component.html',
  styleUrl: './postcard.component.css',
})
export class PostcardComponent {
  /* dato que tiene que ser dado */

  constructor(private router: Router) {}
  @Input() post!: Post;
  @Input() mostrar: boolean = true;

  verDetalle(id: number) {
    // proceso datos
    this.router.navigate(['/detail', id]);
  }
}
