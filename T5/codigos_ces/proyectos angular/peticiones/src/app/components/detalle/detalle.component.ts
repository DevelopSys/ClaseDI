import { Component } from '@angular/core';
import { ApiService } from '../../service/api.service';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../../model/modelos';

@Component({
  selector: 'app-detalle',
  standalone: false,
  templateUrl: './detalle.component.html',
  styleUrl: './detalle.component.css',
})
export class DetalleComponent {
  post: Post | undefined = undefined;

  constructor(
    private apiservice: ApiService,
    private activated: ActivatedRoute
  ) {
    this.activated.params.subscribe((param) => {
      // param["id"]
      this.apiservice.getPostById(param['id']).subscribe((data) => {
        this.post = data;
      });
    });
  }
}
