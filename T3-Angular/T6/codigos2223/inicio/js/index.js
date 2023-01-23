console.log("Script ejecutado desde fuera");

// Variables
// no existen tipos en definicion --> NO TIPADO
let numero = 5; // NUMBER Integer
let numeroDecimal = 3.14; // NUMBER Float
let palabras = "Esto es un ejemplo de palabra en JS"; // string
let letras = "A"; // string --> char
let experiencia = true; // boolean
let sinDefinir = undefined; // undefined
let objeto = null; // null
let coleccion = []; // array --> Any
let fechaActual = new Date();

/* console.log(typeof numero);
console.log(typeof numeroDecimal);
console.log(typeof palabras);
console.log(typeof letras);
console.log(typeof experiencia);
console.log(typeof sinDefinir);
console.log(typeof objeto);
console.log(typeof coleccion);
console.log(typeof fechaActual);
 */

//alert("Ejemplo de mensaje de aviso"); --> no hay interaccion
//confirm("Ejemplo de mensaje de confirmación"); --> hay interaccion
//prompt("Ejemplo de mensaje de introducción"); --> hay interaccion

/* let confirmacion = confirm("Estas seguro que quieres continuar");
console.log(confirmacion);

// calculadora
// se piden por prompt dos datos --> op1 y op2
let numeroUno = Number(prompt("Introduce el primer valor"));
let numeroDos = Number(prompt("Introduce el segundo valor"));

// condicion ? cuandro es true : cuando es false
isNaN(numeroUno) ? console.log("es numero") : console.log("no es numero");

if (!isNaN(numeroUno) && !isNaN(numeroDos)) {
  // si son numeros
  console.log(
    `La suma de ambos números es ${numeroUno} + ${numeroDos} es  ${
      numeroUno + numeroDos
    }`
  );
  console.log(
    `La resta de ambos números es ${numeroUno} - ${numeroDos} es  ${
      numeroUno - numeroDos
    }`
  );
  console.log(
    `La multi de ambos números es ${numeroUno} * ${numeroDos} es  ${
      numeroUno * numeroDos
    }`
  );
  console.log(
    `La división de ambos números es ${numeroUno} / ${numeroDos} es  ${
      numeroUno / numeroDos
    }`
  );
  console.log(
    `La módulo de ambos números es ${numeroUno} % ${numeroDos} es  ${
      numeroUno % numeroDos
    }`
  );
} else {
  alert("Alguno de los datos es incorrecto");
}

if (confirmacion) {
  let datos = Number(prompt("Introduce los datos que se piden"));
  console.log(datos);
  console.log(typeof datos);
} else {
  console.log("No me han confirmado");
  console.log(`${numero} + ${numero2}`);
} */

const elementoNoCambiante = "Dato";
elementoNoCambiante = "asdasdas";
