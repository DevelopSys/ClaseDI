import { Component } from '@angular/core';
import { Asignatura } from '../../model/interfaces';

@Component({
  selector: 'app-for',
  standalone: false,

  templateUrl: './for.component.html',
  styleUrl: './for.component.css',
})
export class ForComponent {
  conocimientoBusqueda: string = '';
  listaAsignaturas: Asignatura[] = [
    {
      imagen:
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTeNhddUQInfcuwztyqws-yWCaGB-y1gzJmg&s',
      nombre: 'Desarrollo de interfaces',
      horas: 6,
      siglas: 'DI',
      profesor: 'Borja Martin',
      conocimientos: ['java', 'js', 'xml', 'html', 'ts', 'angular', 'mysql'],
    },
    {
      imagen:
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQE0iMSHsjb_soqecfxC_dMfsjhNRsMhtU5vw&s',
      nombre: 'Programacion Multimedia',
      horas: 6,
      siglas: 'PMDM',
      profesor: 'Borja Martin',
      conocimientos: ['java', 'kotlin', 'Android', 'firebase'],
    },
    {
      imagen:
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC79ttAB8Lws1AzmQ-PjgxQKIOyly5wxpm0g&s',
      nombre: 'Sistemas de gestión empresarial',
      horas: 3,
      siglas: 'SGE',
      profesor: 'Jorge Cubero',
      conocimientos: ['erp', 'crm', 'odoo', 'soho', 'py'],
    },
    {
      imagen:
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJyPvsrm6Jkz9BC-FLWxttZEUaAYLx2ZZuxw&s',
      nombre: 'Acceso a datos',
      horas: 5,
      siglas: 'AD',
      profesor: 'Alberto Fernandez',
      conocimientos: ['php', 'pasher', 'js', 'mysql'],
    },
  ];

  listaFiltrada: Asignatura[] = this.listaAsignaturas;

  realizarBusqueda() {
    // dependiendo del conocimiento, esta en la lista asignaturas?
    this.listaFiltrada = this.listaAsignaturas.filter((item) =>
      item.conocimientos.includes(this.conocimientoBusqueda)
    );
    console.log(this.conocimientoBusqueda);
    console.log(this.listaFiltrada);
  }
}
