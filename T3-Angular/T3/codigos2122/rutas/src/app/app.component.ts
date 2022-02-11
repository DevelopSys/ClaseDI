import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'rutas-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'rutas';


  constructor( private navegador: Router){

  }

  navegar(navegacion: string, param: string){
      //this.navegador.navigate(['/navegacion'])

      this.navegador.navigate([`/${navegacion}`,`${param}`])
  }
}
