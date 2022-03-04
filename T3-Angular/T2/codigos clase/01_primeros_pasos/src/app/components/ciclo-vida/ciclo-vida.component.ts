import { Component, OnInit, DoCheck, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-ciclo-vida',
  templateUrl: './ciclo-vida.component.html',
  styleUrls: ['./ciclo-vida.component.css']
})
export class CicloVidaComponent implements OnInit, DoCheck, OnDestroy {

titulo = 'Ejemplos de los hooks de un componente';

  constructor() {
    console.log('ejecutado constructor ciclo vida');
   }
  ngOnDestroy(): void {
    console.log('On Destroy ejecutado');
    
  }
  ngDoCheck(): void {
    console.log('Algo ha cambiado en la aplicación');
  }

  ngOnInit(): void {

    console.log('onInit ciclo vida');

  }

  cambiarPropiedad(){
    this.titulo.concat(' cambio');
  }

}
