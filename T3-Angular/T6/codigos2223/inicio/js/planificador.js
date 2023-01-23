let planificador = [];

planificador.push(new Nota("nota1", "descripcion de la nota 1", new Date()));
planificador.push(new Nota("nota2", "descripcion de la nota 2", new Date()));
planificador.push(new Nota("nota3", "descripcion de la nota 3", new Date()));

planificador[0].agregarTarea(new Tarea("Tarea normal1"));
planificador[0].agregarTarea(
  new TareaMultimedia("Multimedia 1", "./images/imagen.png")
);
planificador[0].agregarTarea(
  new TareaTexto("Texto 1", "descripcion del ejemplò")
);

planificador[1].agregarTarea(new Tarea("Tarea normal2"));
planificador[1].agregarTarea(new Tarea("Tarea normal2_2"));

planificador[2].agregarTarea(
  new TareaMultimedia("Tarea multimedia 3", "ruta 1")
);
planificador[2].agregarTarea(
  new TareaMultimedia("Tarea multimedia 3_2", "ruta 1")
);

planificador.forEach((elemento, index) => {
  console.log(`Nota ${index + 1}`);
  elemento.listarTareas();
});
