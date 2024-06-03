import { Component } from '@angular/core';
import { TweetsService } from '../../services/tweets.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css',
})
export class ListarComponent {
  listado: any[] = [];

  constructor(private servicio: TweetsService) {
    this.listado = servicio.tweets;
  }
}
