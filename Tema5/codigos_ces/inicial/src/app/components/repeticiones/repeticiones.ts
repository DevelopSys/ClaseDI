import Swal from 'sweetalert2';
import { Component } from '@angular/core';
import { usuario } from '../../model/usuario';
import { usuarioif } from '../../model/usuarioif';

@Component({
  selector: 'app-repeticiones',
  standalone: false,
  templateUrl: './repeticiones.html',
  styleUrl: './repeticiones.css',
})
export class Repeticiones {
  usuarios: usuario[] = [];
  usuariosIf: usuarioif[] = [{ nombre: 'Borja', apellido: 'Martin', edad: 30, hobbies: [] }];
  // usuarios: string[] = ['Borja', 'Maria', 'Juan', 'Marta', 'Pedro', 'Celia', 'Claudia'];
  nombreIntroducido: string = '';
  apellidoIntroducido: string = '';
  hobbieIntroducido: string = '';
  edadIntroducido: string = '';
  usuario: usuario = new usuario('', '', 0);

  agregarUsuario() {
    // hay datos
    // esta en la lista
    // lo agrego
    /* if (this.nombreIntroducido.length == 0) {
      this.lanzarCuadro('Error', 'No hay datos en el campo', 'error');
    } else if (this.usuarios.find((p) => p.getNombre() == this.nombreIntroducido) != undefined) {
      this.lanzarCuadro('Error', 'El usuario esta en la lista', 'error');
    } else {
      // no tengo que introducir un string, sino un objeto de tipo usuario
      this.usuarios.push(new usuario('Marta', 'Lopez', 30));
      this.lanzarCuadro('Existo', 'Usuario agregado correctamente', 'success');
    } */
    // comprobar que todos los datos estan rellenos
    this.usuario.setNombre(this.nombreIntroducido);
    this.usuario.setApellido(this.apellidoIntroducido);
    this.usuario.setEdad(Number(this.edadIntroducido));
    if (this.usuario.getListaHobbies().length > 0) {
      this.usuarios.push(this.usuario);
      this.lanzarCuadro('Exito', 'Agregado correctamente', 'success');
      // limpiar inputs
      this.usuario = new usuario('', '', 0);
      this.usuario.vaciarHobbies();
    } else {
      this.lanzarCuadro('Error', 'No se puede agregar no hay hobbies', 'error');
    }
  }
  lanzarCuadro(titulo: string, texto: string, icono: string) {
    Swal.fire({
      title: titulo,
      text: texto,
    });
  }

  agregarHobbie() {
    if (this.hobbieIntroducido.length > 0) {
      this.usuario.agregarHobbie(this.hobbieIntroducido);
      this.hobbieIntroducido = '';
    }
  }
}
