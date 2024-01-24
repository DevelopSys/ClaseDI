export interface Coche {
  marca: string;
  modelo: string;
  cv: number;
  cc: number;
  matricula: string;
  tipoMotor: string;
}

export class CocheClase {
  constructor(
    private marca: string,
    private modelo: string,
    private cc: number,
    private cv: number,
    private matricula: string,
    private tipoMotor: string
  ) {}

  mostrarDatos() {}
}
