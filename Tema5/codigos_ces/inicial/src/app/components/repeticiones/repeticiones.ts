import Swal from 'sweetalert2';
import { Component } from '@angular/core';
import { usuario } from '../../model/usuario';

@Component({
  selector: 'app-repeticiones',
  standalone: false,
  templateUrl: './repeticiones.html',
  styleUrl: './repeticiones.css',
})
export class Repeticiones {
  usuarios: usuario[] = [
    new usuario('Borja', 'Martin', 30),
    new usuario('Maria', 'Martin', 40),
    new usuario('Juan', 'Martin', 30),
  ];
  // usuarios: string[] = ['Borja', 'Maria', 'Juan', 'Marta', 'Pedro', 'Celia', 'Claudia'];
  nombreIntroducido: string = '';

  agregarUsuario() {
    // hay datos
    // esta en la lista
    // lo agrego
    if (this.nombreIntroducido.length == 0) {
      this.lanzarCuadro('Error', 'No hay datos en el campo', 'error');
    } else if (this.usuarios.find((p) => p.getNombre() == this.nombreIntroducido) != undefined) {
      this.lanzarCuadro('Error', 'El usuario esta en la lista', 'error');
    } else {
      // no tengo que introducir un string, sino un objeto de tipo usuario
      this.usuarios.push(new usuario('Marta', 'Lopez', 30));
      this.lanzarCuadro('Existo', 'Usuario agregado correctamente', 'success');
    }
  }
  lanzarCuadro(titulo: string, texto: string, icono: string) {
    Swal.fire({
      title: titulo,
      text: texto,
    });
  }
}
