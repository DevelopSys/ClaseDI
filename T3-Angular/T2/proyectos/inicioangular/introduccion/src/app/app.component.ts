import { Component, OnInit } from '@angular/core';
import { Tecnologia } from './utils/tecnologia';
import { TecnologiaInt } from './utils/tecnologia_dos';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'introduccion';
  nombre: string = 'Borja Martin';
  rutaImagen: string = '../assets/images/java.png';
  objetoJava: Tecnologia = new Tecnologia('Java', 'Multiplataforma desarrollado por Oracle', '../assets/images/java.png');
  objetoPs: Tecnologia = new Tecnologia('Powershell', 'Desarrollado para la administración de SO', '../assets/images/powershell.png');
  objetoHtml: Tecnologia = new Tecnologia('HTML', 'DEsarrollado para el desarrollo de paginas webs', '../assets/images/html.jpeg');
  objetoMysql: Tecnologia = new Tecnologia('Mysql', 'Desarrollado para base de datos', '../assets/images/mysql.jpg');
  objetoPhp: Tecnologia = new Tecnologia('PHP', 'Desarrollado para webs dinámicas', '../assets/images/php.png');
  objetoPy: Tecnologia = new Tecnologia('Python', 'Desarrollado para backend y ia', '../assets/images/python.jpg');
  objetoAn: Tecnologia = new Tecnologia('Angular', 'Multiplataforma desarrollado por google', '../assets/images/angular-icon.svg');
  objetoJs: Tecnologia = new Tecnologia('JavaScript', 'BackEnd y FrontEnd', '../assets/images/js.jpg');
  elementos: Tecnologia[] = [this.objetoJava, this.objetoPs, this.objetoHtml, this.objetoMysql, this.objetoPhp, this.objetoPy, 
    this.objetoAn, this.objetoJs];


}
