/* esto es el inicio del codigo JS */
// variables
let nombre = "Borja"; // nombre: string -> Object
let edad = 40; // number
let experiencia = false; // bool
let conocimientos = []; // Object -> Arraylist
let nulo = null; // null
let cosa; // undefined
// NaN -> not a number
const DNI = "123123A";

console.log("Este es el primer mensaje desde codigo JS");
console.log("Esto es un segundo comentario");
console.log("Mi nombre es " + nombre + " y tengo " + edad + " años");
console.log(`Mi nombre es ${nombre} y tengo ${edad} años`);
console.log(`Mi nombre es ${nombre}`);

/* Swal.fire({
  title: "Bienvenido",
  text: `Esto es un mensaje producido por ${nombre}`,
  icon: "success",
}); */
// alert -> muestra info
// confirm -> yes/no
// prompt -> text
/* let resultado = confirm("¿Estas seguro que quieres continuar?");
if (resultado) {
  nombre = prompt("Por favor introduce tu nombre");
  alert(`Bienvenido ${nombre}`);
}
console.log(resultado); */
/* let numeroUno = Number(prompt("Por favor introduce primer numero"));
let numeroDos = Number(prompt("Por favor introduce segundo numero"));
let respuesta = confirm("¿Estas seguro que quieres continuar?");
if (!isNaN(numeroUno) && !isNaN(numeroDos)) {
  if (respuesta) {
    let suma = numeroUno + numeroDos;
    let resta = numeroUno - numeroDos;
    let multi = numeroUno * numeroDos;
    let div = numeroUno / numeroDos;
    let mod = numeroUno % numeroDos;
    alert(
      `Los resultado de las operaciones son\nSuma:${suma}\nResta:${resta}\nMulti:${multi}\nDiv:${div}\nMod ${mod}`
    );
  } else {
    alert("No has continuado, por lo que termino");
  }
} else {
  alert("Cuidado, datos incorrectos");
} */
// pedir por prompt dos numeros
// pedir confirmacion si quiero realizar todas
// las operaciones
// si -> mostrar en un alert todas las operaciones (+,-,*,/,%)
