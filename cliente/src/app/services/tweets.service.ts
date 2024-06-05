import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TweetsService {
  lista: any[] = [];

  constructor() {}

  addTweet(tweet: any) {
    this.lista.push(tweet);
  }

  getTweets() {
    return this.lista;
  }
}
