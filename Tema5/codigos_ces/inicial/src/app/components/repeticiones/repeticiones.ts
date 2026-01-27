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
  usauriosData?: usuario[];
  usuarios: string[] = ['Borja', 'Maria', 'Juan', 'Marta', 'Pedro', 'Celia', 'Claudia'];
  nombreIntroducido: string = '';

  agregarUsuario() {
    // hay datos
    // esta en la lista
    // lo agrego
    if (this.nombreIntroducido.length == 0) {
      this.lanzarCuadro('Error', 'No hay datos en el campo', 'error');
    } else if (this.usuarios.find((p) => p == this.nombreIntroducido) != undefined) {
      this.lanzarCuadro('Error', 'El usuario esta en la lista', 'error');
    } else {
      this.usuarios.push(this.nombreIntroducido);
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
