import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Usuario } from '../../model/modelos';
import { DataService } from '../../services/data.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formulario',
  imports: [FormsModule, CommonModule],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  nombre: string = '';
  apellido: string = '';
  email: string = '';
  pass: string = '';

  constructor(private data: DataService) {}

  guardarUsuario() {
    if (
      this.nombre.length == 0 ||
      this.apellido.length == 0 ||
      this.email.length == 0 ||
      this.pass.length == 0
    ) {
      Swal.fire({
        position: 'center',
        icon: 'error',
        title: 'Error al crear el usuario, faltan datos',
        showConfirmButton: false,
        timer: 2000,
      });
    } else {
      let usuario: Usuario = {
        id: 1,
        nombre: this.nombre,
        apellido: this.apellido,
        email: this.email,
        password: this.pass,
      };
      this.data.addUser(usuario);

      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Usuario creado correctamente',
        showConfirmButton: false,
        timer: 2000,
      });

      this.nombre = '';
      this.email = '';
      this.apellido = '';
      this.pass = '';
    }
    /* console.log('El nombre es: ' + this.nombre);
    console.log('El apellido es: ' + this.apellido);
    console.log('El email es: ' + this.email);
    console.log('La contraseña es: ' + this.pass); */
  }
}
