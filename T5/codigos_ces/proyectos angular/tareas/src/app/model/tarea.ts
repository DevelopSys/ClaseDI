export class Tarea {
  constructor(
    private titulo: string,
    private descripcion: string,
    private completada: boolean
  ) {}

  completarTarea() {
    if (!this.completada) {
      this.completada = true;
    }
  }
}
