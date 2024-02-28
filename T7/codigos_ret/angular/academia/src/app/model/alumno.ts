export class Alumno {
  constructor(
    private nombre: string,
    private apellido: string,
    private dni: string,
    private nia: Number,
    private ciclo: string
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
  public get getCiclo(): string {
    return this.ciclo;
  }
  public set setNia(numero: Number) {
    this.nia = numero;
  }
}
