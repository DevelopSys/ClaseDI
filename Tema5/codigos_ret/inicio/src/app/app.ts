import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { RouterOutlet } from '@angular/router';
import { not } from 'rxjs/internal/util/not';
import { Hobbies } from './components/hobbies/hobbies';
import { Tareas } from './components/tareas/tareas';

@Component({
  selector: 'app-root',
  imports: [FormsModule, RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {}
