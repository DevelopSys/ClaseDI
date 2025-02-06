import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  bindingUno: string | undefined = 'primer binding';
  imagenUrl = 'https://i.ytimg.com/vi/Wjj8fluz6rk/maxresdefault.jpg';

  cambiarImagen(url: string) {
    this.imagenUrl = url;
  }
}
