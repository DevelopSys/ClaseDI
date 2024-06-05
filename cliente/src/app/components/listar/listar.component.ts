import { Component } from '@angular/core';
import { TweetsService } from '../../services/tweets.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css',
})
export class ListarComponent {
  listaTweets: any[] = [];

  // listaTweets = al array que esta en el servicio
  constructor(private servicio: TweetsService) {
    this.listaTweets = servicio.getTweets();
  }
}
