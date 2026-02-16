import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  nombre: string = '';
  apellido = '';
  nota = 0;
  imagen = 'https://cdn-icons-png.flaticon.com/512/3135/3135768.png';
  mostrar = false;
}
