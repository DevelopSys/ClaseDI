import { Component } from '@angular/core';
import { AsignaturaInterfaz } from 'src/app/model/asignatura_interfaz';
import { AsignaturasService } from 'src/app/service/asignaturas.service';

@Component({
  selector: 'app-asignaturas',
  templateUrl: './asignaturas.component.html',
  styleUrls: ['./asignaturas.component.css'],
})
export class AsignaturasComponent {
  asignaturasFiltradas: AsignaturaInterfaz[] = [];
  ciclos: string[] = [];

  constructor(private servicio: AsignaturasService) {
    this.asignaturasFiltradas = servicio.getAllAsignaturas();
    this.ciclos = servicio.getAllCiclos();
  }

  filtrarAsignaturas(ciclo: string, curso: string) {
    this.asignaturasFiltradas = this.servicio.getAsignaturasCursoCiclo(
      ciclo,
      curso
    );
  }

  filtrarConocimientos(conocimiento: string) {
    this.asignaturasFiltradas =
      this.servicio.getAsignaturasConocimiento(conocimiento);
  }
}
