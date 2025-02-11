import { Component } from '@angular/core';
import { Usuario } from '../../model/clases';
import Swal from 'sweetalert2';

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
  usuarios: Usuario[] = [];

  cambiarImagen(url: string) {
    this.imagenUrl = url;
  }

  gestionarCambio(event: Event) {
    // throw new Error('Method not implemented.');
    (event.target! as HTMLInputElement).value;
  }

  agregarUsuario() {
    if (
      (this.nombre.length > 0,
      this.apellido.length > 0,
      this.correo.length > 0,
      this.profesion.length > 0)
    ) {
      this.usuarios.push(
        new Usuario(this.nombre, this.apellido, this.correo, this.profesion)
      );
      this.limpiarDatos();
    } else {
      this.lanzarAviso('No se puede agregar, faltan datos');
    }
  }

  lanzarAviso(msn: string) {
    Swal.fire({
      title: 'Formulario',
      text: msn,
      icon: 'warning',
    });
  }

  limpiarDatos() {
    this.nombre = '';
    this.apellido = '';
    this.correo = '';
    this.profesion = '';
  }

  /* enviarDatos(
    nombre: string,
    apellido: string,
    correo: string,
    profesion: string
  ) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.profesion = profesion;
  } */
}
