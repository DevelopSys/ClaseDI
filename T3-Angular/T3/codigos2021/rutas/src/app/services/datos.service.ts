import { Injectable } from '@angular/core';
import { Asignatura } from '../utils/Asignatura';

@Injectable({
  providedIn: 'root'
})
export class DatosService {

  elementos1: string[] = ["hola","que","tal","estar"];
  elementos2: string[] = ["Esto","es","otra","cosa"];
  elementosJSON: any[] = [
    {nombre:"EJEMPLO1",profesor:"EjemploPR",conocimientos:["asd","asd","asd","asd","asd"]},
    {nombre:"EJEMPLO2",profesor:"EjemploPR",conocimientos:["qwe","qwe","qwe","qwe","qwe"]},
  ]

  asignaturas: Asignatura[] = [
      {
        nombre:"Programacion", siglas:"PMDM",profesor:"Borja"
      },
      {
        nombre:"Desarrollos", siglas:"DI",profesor:"Borja"
      },
      {
        nombre:"Acceso", siglas:"AD",profesor:"David"
      }

  ]

  constructor() { }

  getAsignaturas(): Asignatura[]{
    return this.asignaturas;
  }

  getElementosJSON(){
    return this.elementosJSON;
  }

  getArrayUno() : string[]  {
    return this.elementos1
  }

  getArrayDos() : string[] {
    return this.elementos2
  }
}
