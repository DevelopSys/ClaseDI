/* {
    clave: valor
} */

let lenguajeJSON = {
  nombre: "JavaJSON",
  version: 21,
  usos: ["back", "front", "multi"],
  novedoso: false,
  dificultad: "media",
  mostrarDatos: (param) => {
    console.log(`parametro ${param}}`);
    console.log(`Nombre: ${this.nombre}`);
    console.log(`Version: ${this.version}`);
    console.log(`Tecnologia: ${this.tecnologia}`);
    console.log(`Dificultad: ${this.dificultar}`);
    console.log(`Novedoso: ${this.novedoso}`);
  },
};
lenguajeJSON.mostrarDatos("asdasd");

const lenguajes = [
  new Lenguaje(
    "Java",
    21,
    "Back",
    ["Front", "Back", "Multiplataforma"],
    "media",
    false
  ),
  new Lenguaje(
    "Kotlin",
    15,
    "movil",
    ["movil", "web", "plataforma"],
    "baja",
    true
  ),

  new Lenguaje(
    "Python",
    3,
    "datos",
    ["IA", "BigData", "Analisis"],
    "alta",
    false
  ),
  new Lenguaje(
    "Powershell",
    4,
    "sistemas",
    ["automatizacion", "scripting"],
    "media",
    true
  ),
];

lenguajes
  .filter((e) => e.novedoso)
  .forEach((e1) => {
    console.log(`Los usos del lenguaje ${e1.nombre}`);
    e1.usos.forEach((e2) => {
      console.log(e2);
    });
  });

// SACAR LOS USOS DE TODOS AQUELLOS LENGUAJES
// QUE SEAN NOVEDOSOS

// console.log(lenguajes[lenguajes.length - 1]);
// lenguajes.length
/* lenguajes.forEach((element, index) => {
  if (index % 2 == 0) {
    console.log(` ${index + 1} ${element}`);
  }
}); */
/* lenguajes

  .fill((element) => element.length >= 6)
  .forEach((element) => {
    console.log(element);
  });
 */

// agregar

lenguajes.push("TypeScript", "C#", "C++");
lenguajes.unshift("ObjetiveC", "PHP");

// eliminar

lenguajes.pop();
lenguajes.shift();
console.log(lenguajes);

console.log(lenguajes[4]);
