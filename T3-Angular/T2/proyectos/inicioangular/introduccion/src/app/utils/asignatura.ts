import { Tecnologia } from './tecnologia';
export interface Asignatura {
    nombre: string;
    ciclo: string;
    siglas: string;
    tecnologias: Tecnologia[];
    conocimientos: string[];
}