import { Component } from '@angular/core';
import { Coche, CocheClase } from '../../model/coche';

@Component({
  selector: 'concesionario-concesionario',
  templateUrl: './concesionario.component.html',
  styleUrl: './concesionario.component.css',
})
export class ConcesionarioComponent {
  motorBuscar: string = '';
  matriculaBuscar: string = '';
  listado: CocheClase[] = [];
  listaCocheBuscado: any[] = [];
  listadoCochesMotor: CocheClase[] = [];

  agregarCoche(
    marca: string,
    modelo: string,
    matricula: string,
    cv: string,
    cc: string,
    motor: string
  ) {
    this.listado.push(
      new CocheClase(marca, modelo, Number(cv), Number(cc), matricula, motor)
    );
  }

  buscarCoche(matricula: string) {
    this.listaCocheBuscado = [];
    let cocheBuscado = this.listado.find((item: CocheClase) => {
      return item.getMatricula == matricula;
    });

    this.listaCocheBuscado.push(cocheBuscado);
  }

  buscarTipoMotor(motor: string) {
    this.listadoCochesMotor = this.listado.filter((item: CocheClase) => {
      return item.getMotor.toLowerCase() == motor.toLowerCase();
    });
  }
}
