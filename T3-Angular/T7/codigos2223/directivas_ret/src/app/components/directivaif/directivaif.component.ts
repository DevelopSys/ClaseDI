import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivaif',
  templateUrl: './directivaif.component.html',
  styleUrls: ['./directivaif.component.css'],
})
export class DirectivaifComponent {
  mostrar = false;
  situacionAlumno: Number = -1;

  evaluarNota(nota: string, cv: boolean) {
    // el alumno supera y cv --> 0
    // el alumno supera y no cv --> 1
    // el alumno no supera --> 2

    if (Number(nota) > 4 && cv) {
      this.situacionAlumno = 0;
    } else if (Number(nota) > 4) {
      this.situacionAlumno = 1;
    } else {
      this.situacionAlumno = 2;
    }
  }
}
