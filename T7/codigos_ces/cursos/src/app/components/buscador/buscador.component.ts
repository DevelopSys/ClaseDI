import { Component } from '@angular/core';
import { AsignaturasService } from '../../services/asignaturas.service';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrl: './buscador.component.css'
})
export class BuscadorComponent {

  nombreBuscar: string = ""
  asignaturaBuscar: string = ""
  conocimientoBuscar: string = ""

  constructor(private servicio: AsignaturasService){
      
  }

  relizarBusqueda(){
    
    
  }

}
