export class Tarea {
  constructor(
    private titulo: string,
    private descripcion: string,
    private completada: boolean
  ) {}

  getTitulo(): string {
    return this.titulo;
  }

  completarTarea() {
    if (!this.completada) {
      this.completada = true;
    }
  }
}
