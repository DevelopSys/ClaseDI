import { Component } from '@angular/core';
import { CommonModule, NgOptimizedImage } from '@angular/common';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-header',
  imports: [CommonModule, NgOptimizedImage, RouterLink],
  templateUrl: './header.component.html'
})
export class HeaderComponent {
}
