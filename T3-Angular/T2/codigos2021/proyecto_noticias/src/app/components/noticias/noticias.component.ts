import { Noticia } from './../../utils/Noticia';
import { RouterModule } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { NoticiasService } from 'src/app/services/noticias.service';

@Component({
  selector: 'app-noticias',
  templateUrl: './noticias.component.html',
  styleUrls: ['./noticias.component.css']
})
export class NoticiasComponent implements OnInit {

  mostrar:boolean = false;
  noticias: Noticia[] ;
  noticiaDetalle: Noticia;

  constructor(private servicioNoticias: NoticiasService) { 
  }

  ngOnInit(): void {
    this.noticias = this.servicioNoticias.getAllNoticias();
  }

  mostrarNoticias(categoria: string){
    //console.log(categoria);
    if(categoria!=="todas"){
      this.noticias = this.servicioNoticias.getNoticiasFiltradas(categoria)  
    } else {
      this.noticias = this.servicioNoticias.getAllNoticias();
    }
    
 
  }

  mostrarDetalle(item: Noticia){
    this.noticiaDetalle = item
    this.mostrar = true;
  }

}
