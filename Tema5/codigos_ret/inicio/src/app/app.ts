import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { RouterOutlet } from '@angular/router';
import { not } from 'rxjs/internal/util/not';
import { Hobbies } from './components/hobbies/hobbies';
import { Tareas } from './components/tareas/tareas';

@Component({
  selector: 'app-root',
  imports: [FormsModule, Hobbies, Tareas],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('inicio');
  nombre: string = '';
  apellido = '';
  nota = 0;
  imagen = 'https://cdn-icons-png.flaticon.com/512/3135/3135768.png';
  mostrar = false;
  seleccion: string = '0';

  procesarRespuesta() {
    if (this.nombre.length > 0 && this.apellido.length > 0) {
      this.mostrar = true;
      Swal.fire({
        icon: 'success',
        title: 'Usuario validado correctamente',
        showConfirmButton: false,
        timer: 3000,
      });
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Faltan datos',
        showConfirmButton: false,
        timer: 2000,
      });
    }
  }
}
