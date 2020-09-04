import { Component, OnInit } from '@angular/core';
import { Ciudad } from '../../utils/Ciudad'

@Component({
  selector: 'app-pipes-perso',
  templateUrl: './pipes-perso.component.html',
  styleUrls: ['./pipes-perso.component.css']
})
export class PipesPersoComponent implements OnInit {

  ciudades: Ciudad[];

  constructor() { }

  ngOnInit(): void {

    this.ciudades = [{
      nombre: "NEW YORK",
      imagen: 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.fondoswiki.com%2Fgalerias%2Ffondos-de-escritorio-de-nueva-york&psig=AOvVaw1MYjpgbLgi2l1-24gKqI10&ust=1599232644624000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJCOhIGkzesCFQAAAAAdAAAAABAD'
    }, {
      nombre: 'SAN FRANCISCO',
      imagen: 'https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.hdfondos.eu%2Fimagen%2F62704%2Fpuente-golden-gate-san-francisco-en-la-noche-fondo-de-pantalla&psig=AOvVaw1iS13Ds69MNUzb5rhevqMX&ust=1599234110514000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICRiLupzesCFQAAAAAdAAAAABAD'
    },
    {
      nombre: 'MADRID',
      imagen: 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vuelaviajes.com%2Fplanes-para-exprimir-la-comunidad-de-madrid-a-fondo%2F&psig=AOvVaw2ELRu6oSJaXDheNV3YdmkQ&ust=1599234159600000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOiuj9KpzesCFQAAAAAdAAAAABAD'
    }];

  }

}
