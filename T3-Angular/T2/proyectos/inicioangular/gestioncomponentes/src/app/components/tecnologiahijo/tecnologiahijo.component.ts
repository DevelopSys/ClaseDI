import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-tecnologiahijo',
  templateUrl: './tecnologiahijo.component.html',
  styleUrls: ['./tecnologiahijo.component.css']
})
export class TecnologiahijoComponent implements OnInit {

  @Input() miArray: string[];

  constructor() { }

  ngOnInit() {
  }

}
