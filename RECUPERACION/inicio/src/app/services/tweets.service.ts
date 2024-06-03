import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TweetsService {
  tweets: any[] = [];

  constructor() {}

  addTweet(tweet: any) {
    this.tweets.push(tweet);
  }
}
