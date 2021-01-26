import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'componente-uno',
  templateUrl: './columna-uno.component.html',
  styleUrls: ['./columna-uno.component.css']
})
export class ColumnaUnoComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  manejoPulsacion(){
    console.log('Boton pulsado desde HTML');
  }


}
