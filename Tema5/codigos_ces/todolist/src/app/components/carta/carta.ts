import { Component, Input } from '@angular/core';
import { tarea } from '../../model/tarea';

@Component({
  selector: 'app-carta',
  standalone: false,
  templateUrl: './carta.html',
  styleUrl: './carta.css',
})
export class Carta {
  @Input() item?: tarea;
}
