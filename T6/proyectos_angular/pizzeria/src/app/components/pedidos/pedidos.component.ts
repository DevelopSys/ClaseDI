import { Component } from '@angular/core';
import { Ingrediente, Pedido } from '../../model/Clases';
import { DataService } from '../../service/data.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pedidos',
  standalone: false,
  templateUrl: './pedidos.component.html',
  styleUrl: './pedidos.component.css',
})
export class PedidosComponent {
  listaIngredientes: Ingrediente[] = [];
  ingredientes: Ingrediente[] = [];
  ingredienteSeleccion!: Ingrediente;
  pedido: Pedido | undefined;
  nombrePedido!: string;
  listaPedidos: Pedido[] = [];
  constructor(private servicio: DataService) {
    this.ingredientes = this.servicio.getIngredientes();
    this.listaPedidos = this.servicio.getAllPedidios();
  }

  agregarIngrediente() {
    if (this.pedido == undefined) {
      this.pedido = new Pedido(this.nombrePedido);
    }
    this.pedido.addIngrediente(this.ingredienteSeleccion);
  }
  enviarPedido() {
    if (this.pedido == undefined) {
      Swal.fire({
        title: 'Error',
        text: 'No hay pedido creado',
        icon: 'error',
      });
    } else {
      this.pedido.calcularPrecio();
      this.servicio.addPedido(this.pedido);
      setTimeout(() => {
        this.listaPedidos.pop();
      }, 15000);
    }
  }
}
