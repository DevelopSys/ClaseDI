import { Component } from '@angular/core';
import { AsignaturasService } from '../../services/asignaturas.service';
import { asignatura } from '../../model/asignatura';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrl: './buscador.component.css'
})
export class BuscadorComponent {

  nombreBuscar: string = ""
  asignaturaBuscar: string = ""
  conocimientoBuscar: string = ""
  asignaturasFiltro: asignatura[] = [] 

  constructor(private servicio: AsignaturasService, private rutaActiva: ActivatedRoute){
      console.log(this.rutaActiva.snapshot.params["curso"]);
      
  }

  relizarBusqueda(){
    
    this.asignaturasFiltro =  this.servicio.getCursoAsignaturas(this.asignaturaBuscar)
  }

}
