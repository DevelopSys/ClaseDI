class tarea_clase {
  constructor(private titulo: string, private descripcion: string) {}

  mostrarDatos() {
    console.log(this.titulo);
  }
}

interface tarea_itf {
  titulo: string;
  descripcion: string;

}


class generica {
  constructor(
    private tareas: tarea_clase[],
    private tareas2: tarea_itf[],
    private tareasGenericas: any
  ) {}

  iniciarPrograma() {
    // meter algunas tareas de los diferentes tipos
    this.tareas.push(
      new tarea_clase("titulo1", "descripcion1"),
      new tarea_clase("titulo2", "descripcion2")
    );

    this.tareas2.push(
      {
        titulo: "titulo1",
        descripcion: "descripcion1",
      },
      {
        titulo: "titulo2",
        descripcion: "descripcion2",
      }
    );
  }
}
