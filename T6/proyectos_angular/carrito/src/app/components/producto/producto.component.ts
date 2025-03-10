import { Component, Input } from '@angular/core';
import { Producto } from '../../model/clases';

@Component({
  selector: 'app-producto',
  standalone: false,
  templateUrl: './producto.component.html',
  styleUrl: './producto.component.css',
})
export class ProductoComponent {
  @Input() producto!: Producto;
}
