import { DatosService } from './../../services/datos.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ciclos',
  templateUrl: './ciclos.component.html',
  styleUrls: ['./ciclos.component.css']
})
export class CiclosComponent implements OnInit {

  //ActivatedRouted
  numero:number;
  elementos: string[]= [];
  elementosJSON: any[] = [];
  constructor(private gestorRutasActivas: ActivatedRoute, private servicioDatos: DatosService) { }

  ngOnInit(): void {
    //console.log(this.gestorRutasActivas.snapshot.paramMap.get('id')); 
    //this.numero =  parseInt(this.getorRutasActivas.snapshot.paramMap.get('id'));
    this.gestorRutasActivas.paramMap.subscribe(param=>{
      //console.log(param.get('id'));
      this.numero = parseInt(param.get('id'));
      console.log(this.numero);
      
      switch (this.numero) {
        case 1:
        //console.log(this.servicioDatos.getArrayUno());
        this.elementos = this.servicioDatos.getArrayUno();
        break;
   
        case 2:
          this.elementos = this.servicioDatos.getArrayDos();
        break;  
      }
      this.elementosJSON = this.servicioDatos.getElementosJSON();  
    })
    //console.log(this.numero);
    
    //console.log(this.servicioDatos.getArrayUno());
  }

}
