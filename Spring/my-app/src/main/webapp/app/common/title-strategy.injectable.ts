import { Injectable } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { RouterStateSnapshot, TitleStrategy } from '@angular/router';


/**
 * Extend all componenent titles with a suffix.
 */
@Injectable()
export class CustomTitleStrategy extends TitleStrategy {

  titleSuffix = $localize`:@@app.title:My App`;

  constructor(private readonly title: Title) {
    super();
  }

  override updateTitle(routerState: RouterStateSnapshot): void {
    const title = this.buildTitle(routerState);
    if (title !== undefined) {
      this.title.setTitle(title + ' - ' + this.titleSuffix);
    } else {
      this.title.setTitle(this.titleSuffix);
    }
  }

}
