// crear un json de notas

let planificador = {
  notas: [
    {
      fecha: new Date(),
      titulo: "Nota 1",
      Descripcion: "descripcion 1",
      completa: false,
      tareas: [
        { titulo: "titulo n1", completa: true, fichero: "./ejemplo" },
        { titulo: "titulo n2", completa: true, fichero: "./ejemplo" },
      ],
    },
  ],
  cantidad: 4,
};
// recorrer las notas y crear tantas cartas como notas tenga el objeto
