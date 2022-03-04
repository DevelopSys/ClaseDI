import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva-for',
  templateUrl: './directiva-for.component.html',
  styleUrls: ['./directiva-for.component.css']
})
export class DirectivaForComponent implements OnInit {

  tecnologias: string[] = ["Java","MySQL","JS","Py","HTML","XML","PS","Dart","Kotlin","Lenguaje1","Lenguaje2","Lenguaje3","Lenguaje4","Lenguaje5"];

  constructor() { }

  ngOnInit(): void {
  }

}
