export class Tarea {
  constructor(
    private nombre: string,
    private descripcion: string,
    private estado: string,
    private importancia: string
  ) {}

  public get getNombre(): string {
    return this.nombre;
  }

  public get getDescripcion(): string {
    return this.descripcion;
  }

  public get getEstado(): string {
    return this.estado;
  }

  public get getImportancia(): string {
    return this.importancia;
  }
}
