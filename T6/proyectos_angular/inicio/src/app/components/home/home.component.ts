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
  nombre = '';
  apellido = '';
  correo = '';
  profesion = '';

  cambiarImagen(url: string) {
    this.imagenUrl = url;
  }

  enviarDatos(
    nombre: string,
    apellido: string,
    correo: string,
    profesion: string
  ) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.profesion = profesion;
  }
}
