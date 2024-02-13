import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'cursos';

constructor(private rutas: Router){

}

  navegar(curso: string){
    this.rutas.navigate(['buscador',curso]) 
  }
}
