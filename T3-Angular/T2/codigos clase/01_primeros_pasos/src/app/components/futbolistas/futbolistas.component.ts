import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-futbolistas',
  templateUrl: './futbolistas.component.html',
  styleUrls: ['./futbolistas.component.css']
})
export class FutbolistasComponent implements OnInit {

  constructor() {

    console.log('ejecutado constructor futbolista');
    
   }

  ngOnInit(): void {

    console.log('onInit fubolistas');

  }

  agregar(){
    let lista = document.getElementById('listaFutbolistas');
    console.log(lista);
    
  }

}
