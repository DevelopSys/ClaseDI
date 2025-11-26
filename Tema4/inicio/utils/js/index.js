console.log("Esta ejecucion se llama desde JS independiente");
/* let datos = "Pagina JS";
if (true) {
  const DNI = "1234A";
  let nombre = "Borja"; // variable que guarda el ambito
  console.log(nombre);
}
console.log(datos);
console.log(asignatura); */
// let nombre = "Borja"; // string
let edad = 41; // number -> int
let altura = 1.74; // number -> double / float
let experiencia = false; // bool
let elementos = []; // object -> Array
let cosa = null; // object -> null
let dato; // undefined
// NaN -> not a number -> isNaN()
/* console.log(
  "Mi nombre es: " + nombre + " tengo experiencia en el sector " + experiencia
); */
/* console.log(
  `Mi nombre es ${nombre} y tengo experiencia el en sector ${experiencia}`
);
console.log(`Mi nombre es ${nombre}`);
 */
// alert(`Bienvenido ${nombre}, vamos a realizar interaccione`);
/* let respuesta = confirm("Estas seguro que quieres continuar");
if (respuesta) {
  alert("El usuario hac contestado true");
} else {
  alert("El usuario hac contestado false");
} */
let nombre = prompt("Por favor introduce tu nombre");
// console.log("La respuesta del usuario es " + respuesta);
let respuesta;
do {
  let operando1 = Number(prompt("Introduce el primer operando")); // NaN
  if (!isNaN(operando1)) {
    let operando2 = Number(prompt("Introduce el primer operando")); // NaN
    if (!isNaN(operando2)) {
      let suma = operando1 + operando2;
      let resta = operando1 - operando2;
      let multi = operando1 * operando2;
      let divi = operando1 / operando2;
      alert(`Suma: ${suma}\nResta: ${resta}\nMulti: ${multi}\nDiv: ${divi}\n`);
      respuesta = prompt("quieres repetir la accion");
    } else {
      alert("El dato es incorrecto");
    }
  } else {
    alert("El dato es incorrecto");
  }
} while (respuesta == "si");

// 3
// "3"
//== -> true
//=== -> false
