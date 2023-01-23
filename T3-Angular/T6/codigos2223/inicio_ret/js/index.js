//
/**/
const noMutable = "asdasdasd";
let mutableConAmbito = 2;

let numero = 2; // number
let numeroDecimal = 2.34; // number
let palabra = "Borja"; // string
let acierto = false; // boolean
let fecha = new Date(); // object
let conjunto = []; // object --> Array
let nulo = null; // object
let sinDefinir = undefined;
// NaN
// isNaN()

/* console.log(typeof numero);
console.log(typeof numeroDecimal);
console.log(typeof acierto);
console.log(typeof palabra);
console.log(typeof fecha);
console.log(typeof conjunto);
console.log(typeof nulo);
console.log(typeof sinDefinir);
console.log(typeof cosaSinDefinir); */

let variableUno = "Cosa 1";
let variableDos = "Cosa 2";
let numeroDefecto = 2;

//console.log(variableUno + " " + variableDos + " " + numeroDefecto);
//console.log(`Elemento de la variable uno ${variableUno.length} ${ variableDos } ${ numeroDefecto }`);
// console.log(`$variableUno ${variableUno}`);

//alert(`Esto es un cuadro de ejemplo ${variableUno}`);
//let respuesta = confirm("La pagina te quiere mandar notificaciones");
let nombre = prompt("Cual es tu nombre");
alert(`Esto es un cuadro de ejemplo ${nombre}`);
//respuesta && console.log("Acepto las condiciones");

/* respuesta
  ? console.log("Acepto las condiciones")
  : console.log("No acepto las condiciones");
 */
/* if (respuesta) {
  console.log("Acepto las condiciones");
} else {

} */

/**
 * Nada mas arrancar la pagina aparece un cuadro pidiendo el nombre
 *  - Si he metido nombre aparece un cuadro de dialogo indicado que introduzca un operador
 *  - aparece un cuadro de dialogo indicado que introduzca un operador
 *  - aparece un cuadro de dialogo de confirmaciones "Borja, ¿quieres ver todas las operaciones entre 5 y 7?"
 *         - en el caso de pulsar SI
 *            se mostrará un cuadro de dialogo de alerta con cada una de las operaciones
 * XXX + XXX = RESULTADO
 *            se mostrará un cuadro de dialogo de alerta con cada una de las operaciones
 * XXX - XXX = RESULTADO
 *            se mostrará un cuadro de dialogo de alerta con cada una de las operaciones
 * XXX / XXX = RESULTADO
 *            se mostrará un cuadro de dialogo de alerta con cada una de las operaciones
 * XXX * XXX = RESULTADO
 *            se mostrará un cuadro de dialogo de alerta con cada una de las operaciones
 * XXX % XXX = RESULTADO
 *         - en el caso de pulsar NO
 *            se mostrará un cuadro de alerta indicando que el proceso termina
 *
 *  Comprobación de errores:
 *      - si no introduzco nombre o uno de los operandos no es un numero no debería continuar con el proceso
 */

let palabraEjemplo = "3";

palabraEjemplo == 3;
palabraEjemplo === 3;
