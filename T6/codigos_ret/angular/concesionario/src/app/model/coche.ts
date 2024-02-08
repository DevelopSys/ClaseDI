export class Coche {
  constructor(
    private marca: string,
    private model: string,
    private matricula: string,
    private cv: number,
    private cc: number,
    private precio: number,
    private motor: string
  ) {}

  public get getMarca(): string {
    return this.marca;
  }
  public get getModelo(): string {
    return this.model;
  }

  public get getPrecio(): number {
    return this.precio;
  }
}
