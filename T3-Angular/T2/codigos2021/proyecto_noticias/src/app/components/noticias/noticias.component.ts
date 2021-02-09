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
  noticiasFiltradas: Noticia[] = [];

  constructor(private servicioNoticias: NoticiasService) { 


  }

  ngOnInit(): void {
    this.noticias = this.servicioNoticias.getAllNoticias();
  }

  mostrarNoticias(categoria: string){
    console.log(categoria);
   
    this.noticiasFiltradas = []
        this.noticias.forEach(element => {
          if (element.category == categoria){
            this.noticiasFiltradas.push(element)
          }
        });

        console.log(this.noticiasFiltradas);
        
  
 
  }

}
