import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-videojuegos',
  templateUrl: './videojuegos.component.html',
  styleUrls: ['./videojuegos.component.css']
})
export class VideojuegosComponent implements OnInit {

  constructor() { 

    console.log('ejecutado constructor videojuegos');

  }

  ngOnInit(): void {

    console.log('onInit videojuegos');
    
  }

}
