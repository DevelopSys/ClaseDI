import { Component } from '@angular/core';
import { Tarea } from '../../model/tarea';
import { TareaITF } from '../../model/tareaInterfaz';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formulario',
  standalone: false,

  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  nombreTarea = '';
  completadaTarea = '';
  descripcionTarea = '';
  listaTareas: Tarea[] = [];
  caso = 0;
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
    { titulo: 'TareaITF', descripcion: 'asdasdasd', completada: false },
  ];

  agregarTarea() {
    if (
      this.nombreTarea.length == 0 ||
      this.descripcionTarea.length == 0 ||
      this.completadaTarea.length == 0
    ) {
      Swal.fire({
        icon: 'error',
        title: 'Algun dato no esta completo',
        showConfirmButton: false,
        timer: 2500,
      });
    } else {
      Swal.fire({
        icon: 'success',
        title: 'Agregado correcamente',
        showConfirmButton: false,
        timer: 2500,
      });
      let completada = false;
      if (this.completadaTarea == '0') {
        completada = false;
      } else {
        completada = true;
      }
      let tarea = new Tarea(
        this.nombreTarea,
        this.descripcionTarea,
        completada
      );

      this.listaTareas.push(tarea);
      console.log(this.listaTareas);
    }
  }

  realizarBusqueda() {
    let busqueda = this.lista.find((item) => item == this.palabraBusqueda);
    if (busqueda != undefined) {
      this.mostrar = true;
    } else {
      this.mostrar = false;
    }
  }
}
