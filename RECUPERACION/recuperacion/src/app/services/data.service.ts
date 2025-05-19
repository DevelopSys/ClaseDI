import { Injectable } from '@angular/core';
import { Usuario } from '../model/modelos';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private usuarios: Usuario[] = [];

  constructor() {}

  addUser(usuario: Usuario) {
    this.usuarios.push(usuario);
  }

  getUsuarios(): Usuario[] {
    return this.usuarios;
  }
}
