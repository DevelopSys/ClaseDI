import { Injectable } from '@angular/core';
import { Pedido } from '../model/clases';

@Injectable({
  providedIn: 'root',
})
export class CompraService {
  carrito: Pedido = {
    id: 0,
    nombre: '',
    precio: 0,
    productos: [],
  };

  pedidos: Pedido[] = [];

  constructor() {}

  getPedidoById(id: number): Pedido {
    return this.pedidos.filter((item) => {
      return (item.id = id);
    })[0];
  }
}
