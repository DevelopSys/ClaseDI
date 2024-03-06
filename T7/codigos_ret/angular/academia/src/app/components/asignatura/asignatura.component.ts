import { Component, Input } from '@angular/core';
import { Asignatura } from '../../model/curso';

@Component({
  selector: 'academia-asignatura',
  templateUrl: './asignatura.component.html',
  styleUrl: './asignatura.component.css',
})
export class AsignaturaComponent {
  @Input() asignatura: Asignatura | undefined = undefined;
}
