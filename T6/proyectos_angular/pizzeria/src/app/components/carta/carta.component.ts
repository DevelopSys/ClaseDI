import { Component } from '@angular/core';
import { Ingrediente, Pizza } from '../../model/Clases';
import { DataService } from '../../service/data.service';

@Component({
  selector: 'app-carta',
  standalone: false,
  templateUrl: './carta.component.html',
  styleUrl: './carta.component.css',
})
export class CartaComponent {
  ingredientes: Ingrediente[] = [];
  ingredienteBusqueda = 'Selecciona opcion';
  listaFiltrada: Pizza[] = [];

  constructor(private servicio: DataService) {
    this.ingredientes = servicio.getIngredientes();
    this.listaFiltrada = this.servicio.getPizzas();
    console.log(this.listaFiltrada.length);
  }

  realizarFiltro() {
    this.listaFiltrada = this.servicio.getPizzas().filter((item) => {
      item.getIngredientes.some((item1) => {
        return item1.getNombre == this.ingredienteBusqueda;
      });
    });
  }
}
