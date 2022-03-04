import { Injectable } from '@angular/core';
import { Tecnologia } from '../utils/Tecnologia';

@Injectable({
  providedIn: 'root',
})
export class TecnologiaService {
  tecnologias: Tecnologia[] = [
    new Tecnologia('html', 'Lenguaje estáticas', 'assets/images/html.jpeg'),
    new Tecnologia(
      'javascript',
      'Leguaje para webs dinámicas',
      'assets/images/js.jpg'
    ),
    new Tecnologia(
      'java',
      'Leguaje para multiplataforma',
      'assets/images/java.png'
    ),
    new Tecnologia('XML', 'Leguaje etiquetado', 'assets/images/xml.jpg'),
    new Tecnologia('Angular', 'FW JavaScript', 'assets/images/angular.png'),
    new Tecnologia(
      'Powershell',
      'Lenguaje automatización',
      'assets/images/powershell.png'
    ),
    new Tecnologia('Python', 'Lenguaje servidor', 'assets/images/python.jpg'),
    new Tecnologia(
      'MySql',
      'Leguaje bases de datos',
      'assets/images/mysql.jpg'
    ),
  ];

  constructor() {}

  getAllTecnologias(): Tecnologia[] {
    return this.tecnologias;
  }

  getTecnoligiasNombre(): Tecnologia[] {
    return [];
  }
}
