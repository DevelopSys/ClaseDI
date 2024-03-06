export class Profesor {
  constructor(
    private nombre: string,
    private apellido: string,
    private dni: string,
    private conocimientos: string[]
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
  public get getConocientos(): string[] {
    return this.conocimientos;
  }
}
