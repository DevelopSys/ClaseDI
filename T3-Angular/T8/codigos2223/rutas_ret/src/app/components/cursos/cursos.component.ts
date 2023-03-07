import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
})
export class CursosComponent {
  // ActivatedRoute

  constructor(private gestorRutas: ActivatedRoute) {
    console.log(gestorRutas);
  }
}
