import { Component } from '@angular/core';
import { hobbieintf } from '../../model/hobbieintf';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-hobbies',
  imports: [FormsModule],
  templateUrl: './hobbies.html',
  styleUrl: './hobbies.css',
})
export class Hobbies {
  nombre?: string;
  nivel?: number;
  fecha?: string;
  hobbies: hobbieintf[] = [];
  // hobbie?: hobbieintf = { nombre: 'Futbol', nivel: 1, fecha: 'agosto' };
  // hobbie: hobbieclass
  /* 
  crear un formulario para poder incluis un hobbie dentro de una lista. 
  Un hobbie tiene como elementos un
  
  nombre (string), nivel (int), fecha (date)

  - Cada vez que se pulse el boton agregar se realiza una confirmacion
  del hobbie
  - Cada vez que agrego un hobbie se lleve a un array
  
  */
  agregarHobbie() {
    // si esta todo ok
    this.hobbies.push({ name: this.nombre, level: this.nivel, date: this.fecha });
    this.nombre = '';
    this.fecha = '';
    this.nivel = 0;
  }
}
