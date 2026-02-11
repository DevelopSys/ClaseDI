export class hobbieclass {
  constructor(
    private nombre: string,
    private nivel: number,
    private fecha: string,
  ) {}

  // metodos

  getNombre() {
    return this.nombre;
  }

  getNivel() {
    return this.nivel;
  }

  getFecha() {
    return this.fecha;
  }
}
