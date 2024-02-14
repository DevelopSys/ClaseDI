import { Component } from '@angular/core';
import { AsignaturasService } from '../../services/asignaturas.service';
import { asignatura } from '../../model/asignatura';
import { ActivatedRoute, ParamMap } from '@angular/router';


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
      //console.log(this.rutaActiva.snapshot.params["curso"]);
      this.rutaActiva.paramMap.subscribe((item: ParamMap)=>{
        // console.log(item.get('curso'));
        let seleccion: any = item.get("curso")
        let nivel: any = item.get("nivel")
        this.asignaturaBuscar = seleccion
        console.log(seleccion);
        console.log(nivel);
        
        this.asignaturasFiltro =  this.servicio.getCursoAsignaturas(seleccion).filter((item)=>{
          return item.nivel == nivel
        })
      })
      
      
  }

  relizarBusqueda(){
    
    this.asignaturasFiltro =  this.servicio.getCursoAsignaturas(this.asignaturaBuscar)
  }

}
