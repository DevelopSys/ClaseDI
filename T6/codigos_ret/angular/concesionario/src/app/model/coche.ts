export class Vehiculo {
  constructor(
    private marca: string,
    private model: string,
    private matricula: string,
    private cv: number,
    private cc: number,
    private precio: number,
    private motor: string,
    private accesorios: string[],
    private tipo: string = ''
  ) {}

  public set setAccesiorios(v: string[]) {
    this.accesorios = v;
  }

  public get getAccesorios(): string[] {
    return this.accesorios;
  }

  public set setPrecio(v: number) {
    this.precio = v;
  }

  public get getMarca(): string {
    return this.marca;
  }
  public get getModelo(): string {
    return this.model;
  }

  public get getPrecio(): number {
    return this.precio;
  }

  public get getTipo(): string {
    return this.tipo;
  }
}
