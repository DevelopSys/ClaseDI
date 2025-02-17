import { Component } from '@angular/core';
import { Asignatura } from '../../model/interfaces';

@Component({
  selector: 'app-for',
  standalone: false,

  templateUrl: './for.component.html',
  styleUrl: './for.component.css',
})
export class ForComponent {
  listaAsignaturas: Asignatura[] = [
    {
      nombre: 'Desarrollo de interfaces',
      horas: 6,
      siglas: 'DI',
      profesor: 'Borja Martin',
      conocimientos: ['java', 'js', 'xml', 'html', 'ts', 'angular', 'msql'],
    },
    {
      nombre: 'Programacion Multimedia',
      horas: 6,
      siglas: 'PMDM',
      profesor: 'Borja Martin',
      conocimientos: ['java', 'kotlin', 'Android', 'firebase'],
    },
    {
      nombre: 'Sistemas de gestión empresarial',
      horas: 3,
      siglas: 'SGE',
      profesor: 'Jorge Cubero',
      conocimientos: ['erp', 'crm', 'odoo', 'soho', 'py'],
    },
    {
      nombre: 'Acceso a datos',
      horas: 5,
      siglas: 'AD',
      profesor: 'Alberto Fernandez',
      conocimientos: ['php', 'pasher', 'js', 'mysql'],
    },
  ];
}
