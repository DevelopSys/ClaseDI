import { Component } from '@angular/core';

@Component({
  selector: 'app-escribir',
  templateUrl: './escribir.component.html',
  styleUrl: './escribir.component.css',
})
export class EscribirComponent {
  texto: string = '';
  nombre: string = '';
  categoria: string = '';
  condiciones: boolean = false;
  listaTweets: any[] = [];

  lanzarTweet() {
    if (!this.condiciones) {
      alert('Acepta condiciones');
    } else if (
      this.texto.length == 0 ||
      this.categoria.length == 0 ||
      this.nombre.length == 0
    ) {
      alert('Por favor introduce datos');
    } else {
      /* lanzar el tweet */
      /* Agregar en el [] listaTweets el conjunto de datos que estan en los inputs */
      this.listaTweets.push({
        autor: this.nombre,
        contenido: this.texto,
        tipo: this.categoria,
      });

      alert('Mensaje enviado correctamente');
      this.nombre = '';
      this.texto = '';
      this.condiciones = false;
    }
  }
}
