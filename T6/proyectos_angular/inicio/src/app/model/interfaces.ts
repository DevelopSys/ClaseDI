/* 
conjunto de metodos ABS -> excepto defauls
    sirve para poner en comun funcionalidades -> polimorfismo
conjunto de constantes -> final / public / static
un objeto -> JSON donde solo se indica nombre, tipo (incluidas funciones, sin cuerpo)
*/
export interface Usuario {
  nombre: string;
  apellido: string;
  correo: string;
  profesion: string;
  edad: number;
}

export interface Asignatura {
  imagen: string;
  nombre: string;
  siglas: string;
  horas: number;
  profesor: string;
  conocimientos: string[];
}
