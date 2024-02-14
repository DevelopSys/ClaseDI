import { Component, Input } from '@angular/core';
import { asignatura } from '../../model/asignatura';

@Component({
  selector: 'app-carta-asignatura',
  templateUrl: './carta-asignatura.component.html',
  styleUrl: './carta-asignatura.component.css'
})
export class CartaAsignaturaComponent {

  @Input() asignatura: asignatura= {nombre:"",conocimientos:[],curso:"",horas:2,imagen:"",profesor:"",nivel:1,siglas:""}

}
