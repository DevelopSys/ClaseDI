import { Component } from '@angular/core';
import { CompraService } from '../../services/compra.service';
import { ActivatedRoute } from '@angular/router';
import { Pedido } from '../../model/clases';

@Component({
  selector: 'app-detalle',
  standalone: false,
  templateUrl: './detalle.component.html',
  styleUrl: './detalle.component.css',
})
export class DetalleComponent {
  pedido!: Pedido;

  constructor(
    private compraService: CompraService,
    private activatedRoute: ActivatedRoute
  ) {
    console.log(this.compraService.pedidos);
    this.compraService.pedidos.forEach((item) => {
      console.log(item.id);
    });

    activatedRoute.params.subscribe((data) => {
      let id = data['id'];
      this.pedido = this.compraService.getPedidoById(id);
    });
  }
}
