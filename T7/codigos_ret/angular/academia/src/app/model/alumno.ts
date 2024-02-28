export class Alumno {
  constructor(
    private nombre: string,
    private apellido: string,
    private dni: string,
    private nia: Number
  ) {}

  public get getNombre(): string {
    return this.nombre;
  }
  public get getApellido(): string {
    return this.apellido;
  }
  public get getDni(): string {
    return this.dni;
  }
  public get getNia(): Number {
    return this.nia;
  }
  public set setNia(numero: Number) {
    this.nia = numero;
  }
}
