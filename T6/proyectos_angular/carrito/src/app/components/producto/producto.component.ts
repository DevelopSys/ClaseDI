import { Component, Input } from '@angular/core';
import { Producto } from '../../model/clases';
import { CompraService } from '../../services/compra.service';

@Component({
  selector: 'app-producto',
  standalone: false,
  templateUrl: './producto.component.html',
  styleUrl: './producto.component.css',
})
export class ProductoComponent {
  @Input() producto!: Producto;

  constructor(private compraService: CompraService) {}

  realizarAccion(producto: Producto) {
    // al pulsarlo se agregar a un pedido
    this.compraService.carrito.productos.push(producto);
  }
}
