let tarea = new Tarea("Tarea1", "Alta", false);
let tareaOcio = new TareaOcio("Tarea2", "Media", false, "parque");
let tareaTrabajo = new TareaTrabajo("Tarea3", "Baja", false, 40000);
let tareaJSON = {
  titulo: "Tarea 4",
  prioridad: "Media",
  completada: false,
  mostrarDatos: function () {
    console.log(`Titulo ${this.titulo}`);
    console.log(`Prioridad ${this.prioridad}`);
    console.log(`Completada ${this.completada}`);
  },
  mostrarImportancia: (prioridad) => {
    if (prioridad == tareaJSON.prioridad) {
      console.log("Prioridad completada");
    } else {
      console.log("prioridad diferente");
    }
  },
};

tareaJSON.mostrarDatos();
//tareaJSON.mostrarImportancia("media");
/* JavaScriptObject Notatio
par clave - valor
*/
/* let tareas = [tarea, tareaOcio, tareaTrabajo];
tareas.forEach((element, index) => {
  console.log(`Tarea ${index + 1}`);
  element.mostrarDatos();
}); */

/*
Tarea 1
Titulo: Tarea1
tareas.js:10 Prioriordad: Alta
tareas.js:11 Completada: false

Tarea 2
Titulo: Tarea1
tareas.js:10 Prioriordad: Alta
tareas.js:11 Completada: false
asdasdasdasd

Tarea 3
Titulo: Tarea1
tareas.js:10 Prioriordad: Alta
tareas.js:11 Completada: false
asdasdasdasdasdasd
*/

// tarea.mostrarDatos();
// tarea.setPrioridad = "Media";
// console.log(tarea.getPrioridad);
// tareaTrabajo.mostrarDatos();
