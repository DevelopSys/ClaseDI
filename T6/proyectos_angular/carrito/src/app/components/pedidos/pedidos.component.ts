import { Component } from '@angular/core';
import { CompraService } from '../../services/compra.service';
import { Pedido } from '../../model/clases';

@Component({
  selector: 'app-pedidos',
  standalone: false,
  templateUrl: './pedidos.component.html',
  styleUrl: './pedidos.component.css',
})
export class PedidosComponent {
  pedidos: Pedido[] = [];

  constructor(private compraService: CompraService) {
    this.pedidos = compraService.pedidos;
  }
}
