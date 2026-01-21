import { Component } from '@angular/core';

@Component({
  selector: 'app-decisiones',
  standalone: false,
  templateUrl: './decisiones.html',
  styleUrl: './decisiones.css',
})
export class Decisiones {
  mostrar: boolean = true;
  nombre = '';
  apellido = '';
  edad = 0;
  salario = 0;
  experiencia = 0;
  resolucion = false;
  analizada = false;

  cambiarMostar() {
    this.mostrar = !this.mostrar;
  }
  contratar() {
    if (this.edad > 18) {
      if (this.salario < 20000 && this.experiencia < 2) {
        this.resolucion = true;
      } else if (this.salario < 50000 && this.experiencia > 3) {
        this.resolucion = true;
      } else if (this.experiencia > 10) {
        this.resolucion = true;
      } else {
        this.resolucion = false;
      }
    } else {
      this.resolucion = false;
    }
    this.analizada = true;
    setTimeout(() => {
      this.resetearDatos();
    }, 5000);
  }

  resetearDatos() {
    this.analizada = false;
    this.resolucion = false;
    this.nombre = '';
    this.apellido = '';
    this.edad = 16;
    this.salario = 0;
    this.experiencia = 1;
  }
}
