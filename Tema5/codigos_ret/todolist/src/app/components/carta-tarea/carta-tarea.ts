import { Component, Input } from '@angular/core';
import { ImagenesPipe } from '../../pipes/imagenes-pipe';
import { CommonModule } from '@angular/common';
import { Tarea } from '../../model/tarea';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-carta-tarea',
  imports: [ImagenesPipe, CommonModule, RouterLink],
  templateUrl: './carta-tarea.html',
  styleUrl: './carta-tarea.css',
})
export class CartaTarea {
  @Input() item?: Tarea;
}
