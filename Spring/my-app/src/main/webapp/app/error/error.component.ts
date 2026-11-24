import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { getReasonPhrase } from 'http-status-codes';


@Component({
  selector: 'app-error',
  imports: [CommonModule],
  templateUrl: './error.component.html'
})
export class ErrorComponent implements OnInit {

  router = inject(Router);

  status = '404';
  error = getReasonPhrase(this.status);

  ngOnInit() {
    const currentNavigation = this.router.lastSuccessfulNavigation();
    if (currentNavigation?.initialUrl.toString() !== '/error') {
      // show not found
      return;
    }
    const navigationState = currentNavigation.extras.state;
    this.status = navigationState?.['errorStatus'] || '503';
    this.error = navigationState?.['errorMessage'] || getReasonPhrase(this.status);
  }

}
