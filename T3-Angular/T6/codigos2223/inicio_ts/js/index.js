console.log("Declaracion de variables");
// let var const
var profesor1 = {
    nombre: "Borja",
    apellido: "Martin",
    asignaturas: [
        { nombre: "Programacion", horas: 8 },
        { nombre: "Desarrollo interfaces", horas: 6 },
    ]
};
var profesor2 = {
    nombre: "Jesus",
    apellido: "Niño",
    asignaturas: [
        { nombre: "Programacion procesos", horas: 4 },
        { nombre: "Entornos de desarrollo", horas: 3 },
    ]
};
function mostrarAsignaturas(asignaturas) {
    asignaturas.forEach(function (element) {
        console.log(element.nombre);
    });
}
mostrarAsignaturas(profesor2.asignaturas);
/* let nombre: String = "Borja";
let edad: Number = 38;
let asignaturas: Array<String> = [
  "Programacion",
  "Desarrollo interfaces",
  "Programacion Multimedia",
];

asignaturas.forEach((element) => {
  console.log(element);
});
*/
