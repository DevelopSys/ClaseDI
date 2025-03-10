import { Component } from '@angular/core';
import { CompraService } from '../../services/compra.service';
import { Pedido, Producto } from '../../model/clases';

@Component({
  selector: 'app-carrito',
  standalone: false,
  templateUrl: './carrito.component.html',
  styleUrl: './carrito.component.css',
})
export class CarritoComponent {
  productos: Producto[] = [];
  nombre: string = '';

  constructor(private compraService: CompraService) {
    this.productos = compraService.carrito.productos;
  }

  realizarCompra() {
    // 1-calcula precio
    let precio: number = 0;
    this.productos.forEach((element) => {
      precio += element.precio;
    });
    // 2-nombre
    // 3-productos
    // 4-id:tamaño de la lista de productos
    let pedido: Pedido = {
      id: this.compraService.pedidos.length,
      nombre: this.nombre,
      precio: precio,
      productos: this.productos,
    };

    this.compraService.pedidos.push(pedido);
    this.limpiarCarrito();
  }
  limpiarCarrito() {
    this.compraService.carrito = {
      id: 0,
      nombre: '',
      precio: 0,
      productos: [],
    };
    this.productos = [];
  }
}
