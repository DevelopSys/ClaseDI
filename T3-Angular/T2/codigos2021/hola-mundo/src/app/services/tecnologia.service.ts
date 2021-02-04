import { Injectable } from '@angular/core';
import { Tecnologia } from '../utils/Tecnologia';

@Injectable({
  providedIn: 'root',
})
export class TecnologiaService {
  tecnologias: Tecnologia[] = [
    new Tecnologia('html', 'Lenguaje estáticas', 'assets/images/html.jpeg'),
    new Tecnologia('js', 'Leguaje para webs dinámicas', 'assets/images/js.jpg'),
    new Tecnologia('Java', 'Leguaje para multiplataforma', ''),
    new Tecnologia('XML', 'Leguaje etiquetado', ''),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
    new Tecnologia('asdasd', 'Leguaje etiquetado', 'assets/images/js.jpg'),
  ];

  constructor() {}

  getAllTecnologias(): Tecnologia[] {
    return this.tecnologias;
  }
}
