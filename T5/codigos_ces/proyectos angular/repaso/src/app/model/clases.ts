export class Tarea {
  constructor(
    private titulo: string,
    private descripcion: string,
    private estado: boolean,
    private subtareas: SubTarea[]
  ) {}

  get getDescripcion() {
    return this.descripcion;
  }

  get getTitulo() {
    return this.titulo;
  }
  set setTitulo(titulo: string) {
    this.titulo = titulo;
  }

  get getSubtareas() {
    return this.subtareas;
  }

  set setSubtareas(tareas: SubTarea[]) {
    this.subtareas = tareas;
  }
}

export class SubTarea {
  constructor(
    private nombre: string,
    private dificultad: string,
    private tipo: string
  ) {}

  get getTitulo() {
    return this.nombre;
  }
}
