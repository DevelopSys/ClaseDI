import { Profesor } from './profesor';

export interface Asignatura {
  id: Number;
  nombre: string;
  siglas: string;
  horas: Number;
  conocimientos: string[];
  ciclo: string;
  nivel: Number;
  profesor: Profesor | null;
  imagen: string;
}
