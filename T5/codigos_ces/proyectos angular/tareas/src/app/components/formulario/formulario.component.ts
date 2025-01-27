import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import { TareaITF } from '../../model/tareaInterfaz';

@Component({
  selector: 'app-formulario',
  standalone: false,

  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  mostrar: boolean = false;
  palabraBusqueda: string = '';
  lista: string[] = ['ejemplo', 'programacion', 'datos', 'cuestiones'];
  tareasOBJ: Tarea[] = [
    new Tarea('Tarea1', 'Descripcion1', false),
    new Tarea('Tarea2', 'Descripcion2', false),
    new Tarea('Tarea3', 'Descripcion3', false),
    new Tarea('Tarea4', 'Descripcion4', false),
    new Tarea('Tarea5', 'Descripcion5', false),
  ];
  tareasITF: TareaITF[] = [
    { titulo: 'TareaITF', descripcion: 'asdasdasd', completada: false},
  ];

  realizarBusqueda() {
    let busqueda = this.lista.find((item) => item == this.palabraBusqueda);
    if (busqueda != undefined) {
      this.mostrar = true;
    } else {
      this.mostrar = false;
    }
  }
}
