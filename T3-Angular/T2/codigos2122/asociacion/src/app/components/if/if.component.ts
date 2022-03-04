import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'asociacion-if',
  templateUrl: './if.component.html',
  styleUrls: ['./if.component.css']
})
export class IfComponent implements OnInit {

  mostrar: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  cambiarEstado(){
    /* if (this.mostrar){
      this.mostrar = false;
    } else {
      this.mostrar = true;
    } */

    this.mostrar = !this.mostrar;
  }

}
