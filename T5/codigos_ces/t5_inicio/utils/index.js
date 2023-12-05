// variable de bloque
let nombre = "Borja"; // string -> object
let edad = 39; // number
let experiencia = false; // boolean
let carnet = null; // null
let portatil; // undefield
let hobbies = [];
console.log(typeof portatil);

const nombres = ["Borja", "Juan", "Celia"];
// constante
const DNI = "1231231";

// console.log("Mensaje que quiero sacar por consola");
// console.log(`El nombre del usuario es ${nombre}`);
// console.log(`El nombre del usuario es ${nombre}`);

//alert("Estas segudo que esto es un aviso");
/* const respuesta = confirm("Estas seguro que quieres borrar los datos");
if (respuesta) {
  console.log("El usuario ha contestado ok");
} else {
  console.log("El usuario ha contestado no ok");
} */

//const nombreUsuario = prompt("Por favor introduce tu nombre");
/* if (nombreUsuario == null || nombreUsuario.length == 0) {
  alert("Faltan datos");
} else {
  console.log(`El nombre introducido por el usuario es ${nombreUsuario}`);
} */
let numeroUno = Number(prompt("Introduce operando 1"));

if (isNaN(numeroUno)) {
  alert("Dato incorrecto");
} else {
  let numeroDos = Number(prompt("Introduce operando 2"));
  if (isNaN(numeroDos)) {
    alert("Dato incorrecto");
  } else {
  /*   let suma = numeroUno + numeroDos;
    let resta = numeroUno - numeroDos;
    let multi = numeroUno * numeroDos;
    let divi = numeroUno / numeroDos;
    let resto = numeroUno % numeroDos; */
    alert(
      `Los resultados de las operaciones son\nSuma: ${
        numeroUno + numeroDos
      }\nResta: ${numeroUno - numeroDos}\nMulti: ${
        numeroUno * numeroDos
      }\nDivision: ${numeroUno / numeroDos}\nModulo: ${numeroUno % numeroDos}`
    );
  }
}
