let tarea1 = new Tarea("Tarea1", "Alta", false);
let tarea2 = new Tarea("Tarea1", "Alta", true);
let tarea3 = new Tarea("Tarea1", "Alta", false);
let tarea4 = new Tarea("Tarea1", "Alta", true);
let tarea5 = new Tarea("Tarea1", "Alta", false);
let tareaOcio1 = new TareaOcio("Tarea2", "Media", false, "parque");
let tareaOcio2 = new TareaOcio("Tarea2", "Media", true, "parque");
let tareaOcio3 = new TareaOcio("Tarea2", "Media", true, "parque");
let tareaOcio4 = new TareaOcio("Tarea2", "Media", true, "parque");
let tareaTrabajo1 = new TareaTrabajo("Tarea3", "Baja", true, 40000);
let tareaTrabajo2 = new TareaTrabajo("Tarea3", "Baja", true, 40000);
let tareaTrabajo3 = new TareaTrabajo("Tarea3", "Baja", true, 40000);
let tareaTrabajo4 = new TareaTrabajo("Tarea3", "Baja", false, 40000);
let tareaTrabajo5 = new TareaTrabajo("Tarea3", "Baja", true, 40000);
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

let tareas = [
  tarea1,
  tarea2,
  tarea3,
  tarea4,
  tarea5,
  tareaOcio1,
  tareaOcio2,
  tareaOcio3,
  tareaOcio4,
  tareaTrabajo1,
  tareaTrabajo2,
  tareaTrabajo3,
  tareaTrabajo4,
  tareaTrabajo5,
  tareaJSON,
];

// lista
tareas
  .filter((element) => {
    return element.completada;
  })
  .forEach((item) => {
    console.log(item);
  });

/* tareas.forEach((element) => {
  if (!element.completada) {
    element.mostrarDatos();
  }
}); */

// mostrar solo las completadas

// tareaJSON.mostrarDatos();
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

// baraja = [cartas]
// Cartas -> new Carta(QC)
// valor -> 10 -> calculado
// palo -> C -> calculado
// representacion QC
// imagen QC.png -> calculado
