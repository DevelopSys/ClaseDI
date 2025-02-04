import { Asignatura } from './asignatura';

export interface Curso {
  id: number;
  nombre: string;
  nivel: number;
  asignaturas: Asignatura[];
  familia: string;
}
