import { Component, Input } from '@angular/core';
import { Post } from '../../model/interfeces';

@Component({
  selector: 'app-post',
  standalone: false,
  templateUrl: './post.component.html',
  styleUrl: './post.component.css',
})
export class PostComponent {
  @Input() item!: Post;
}
