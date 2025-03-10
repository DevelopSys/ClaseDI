import { Component } from '@angular/core';
import { Producto } from '../../model/clases';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-listado',
  standalone: false,
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  listaProductos!: Producto[];
  constructor(private apiService: ApiService) {
    apiService.getAllProducts().subscribe((data) => {
      this.listaProductos = data;
    });
  }
}
