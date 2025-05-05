import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

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

  guardarUsuario() {
    console.log('El nombre es: ' + this.nombre);
    console.log('El apellido es: ' + this.apellido);
    console.log('El email es: ' + this.email);
    console.log('La contraseña es: ' + this.pass);
  }
}
