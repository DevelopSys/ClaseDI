import { Component } from '@angular/core';
import { hobbieintf } from '../../model/hobbieintf';

@Component({
  selector: 'app-hobbies',
  imports: [],
  templateUrl: './hobbies.html',
  styleUrl: './hobbies.css',
})
export class Hobbies {
  hobbie?: hobbieintf = { nombre: 'Futbol', nivel: 1, fecha: 'agosto' };
  // hobbie: hobbieclass
  /* 
  crear un formulario para poder incluis un hobbie dentro de una lista. 
  Un hobbie tiene como elementos un
  
  nombre (string), nivel (int), fecha (date)

  - Cada vez que se pulse el boton agregar se realiza una confirmacion
  del hobbie
  - Cada vez que agrego un hobbie se lleve a un array
  
  */
}
