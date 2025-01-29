import { Component } from '@angular/core';
import { Tarea, SubTarea } from '../../model/clases';

@Component({
  selector: 'app-listado',
  standalone: false,

  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css',
})
export class ListadoComponent {
  mostrar = true;
  tareas: Tarea[] = [
    new Tarea('Titulo1', 'descripcion1', false, [
      new SubTarea('Subtarea1', 'alta', 'estudio'),
    ]),
    new Tarea('Titulo2', 'descripcion2', false, [
      new SubTarea('Subtarea1', 'alta', 'estudio'),
      new SubTarea('Subtarea2', 'alta', 'estudio'),
      new SubTarea('Subtarea3', 'alta', 'estudio'),
    ]),
    new Tarea('Titulo3', 'descripcion3', false, [
      new SubTarea('Subtarea1', 'alta', 'estudio'),
      new SubTarea('Subtarea2', 'media', 'estudio'),
      new SubTarea('Subtarea3', 'baja', 'estudio'),
    ]),
  ];

  nombre: string = '';
  opcionSelect: string = 'asd';

  mostrarDetalle(arg0: string) {
    console.log(arg0);
  }
  agregar() {
    this.mostrar = !this.mostrar;
    this.tareas.push(new Tarea(this.nombre, 'Descripcion', true, []));
    this.nombre = '';
    console.log(Number(this.opcionSelect));
  }

  obtenerCambio() {
    console.log(this.opcionSelect);
    this.tareas.filter((item) => {
      return item.getTitulo == this.opcionSelect;
    });
  }

  obtenerInput() {
    console.log(this.nombre);
  }
}
