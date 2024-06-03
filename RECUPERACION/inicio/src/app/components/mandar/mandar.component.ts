import { Component } from '@angular/core';
import { TweetsService } from '../../services/tweets.service';

@Component({
  selector: 'app-mandar',
  templateUrl: './mandar.component.html',
  styleUrl: './mandar.component.css',
})
export class MandarComponent {
  nombre: string = '';
  categoria: string = '';
  texto: string = '';

  constructor(private servicio: TweetsService) {}

  mandarTweet() {
    /* a base de datos */
    if (
      this.nombre.length > 0 &&
      this.categoria.length > 0 &&
      this.texto.length > 0
    ) {
      this.servicio.addTweet({
        nombreT: this.nombre,
        categoriaT: this.categoria,
        textoT: this.texto,
      });
    } else {
      alert('No se puede mandar, está vacio');
    }
  }
}
