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
    private precio: number,
    private tipoMotor: string
  ) {}

  mostrarDatos() {}

  public get getMatricula(): string {
    return this.matricula;
  }

  public get getMotor(): string {
    return this.tipoMotor;
  }

  public get getMarca(): string {
    return this.marca;
  }

  public get getModelo(): string {
    return this.modelo;
  }
}
