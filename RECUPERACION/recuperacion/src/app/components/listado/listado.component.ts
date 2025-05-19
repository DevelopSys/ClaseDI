import { Component } from '@angular/core';
import { Usuario } from '../../model/modelos';
import { CommonModule } from '@angular/common';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-listado',
  imports: [CommonModule],
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  usuarios: Usuario[] = [];
  constructor(private data: DataService) {
    this.usuarios = data.getUsuarios();
  }
}
