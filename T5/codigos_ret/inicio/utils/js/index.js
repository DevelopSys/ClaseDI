console.log("Pimera linea en JS");
// var -> ambito global
// let
// const -> final
let edad = 29; // number
let pi = 3.1415; // number
let acierto = false; // boolean
let cosas = []; // Object -> Array
let nombre = "Borja"; // string
let letra = "A"; // string
let sinDefinir; // undefined
let nulo = null; // null
let fecha = new Date();
// NaN -> Not a Number
// isNaN(x) -> t o f
console.log(typeof edad);
console.log(fecha);
console.log("Esto es un ejemplo de log por consola");
console.log(`Esto es un ejemplo de formateo realizado por ${nombre}`);
console.log(`Esto es un ejemplo de cosa para formatear ${nombre}`);
// alert(`Mi nombre es ${nombre} y tengo ${edad}`);
/* let resupuesta = confirm("¿Estas seguro que quieres continuar?");
if (resupuesta) {
  console.log("Todo ok, continuamos");
} else {
  console.log("Terminamos el proceso");
} */
// let nombreIntro = prompt("Por favor introduce tu nombre");
// console.log(nombreIntro);

/* 
Realizar la siguiente funcionalidad:
- Se le pediran al usuario 2 numeros (en dos cuadros diferentes)
- Tras la peticion de cada uno de los numeros, si lo son se continua, en caso caso
 contrario
alerta y se para
- Si se introducen numeros en ambos casos, se mostrarán todas las operaciones en un 
alert
    - suma (+)
    - resta (-)
    - division (/)
    - multi (*)
    - modulo (%)

MODIFICACION:
- si le doy cancelar en algun momento, termina
- si meto un NaN o termino de hacer operaciones, pregunta si quiero volver a operar
    - si le digo que si, continua
    - si le digo que no, termina
*/

let numero = 1;
let numero2 = "1";
let repetir = false;

do {
  let numeroUno = Number(prompt("introduce numero 1"));
  // si el numeroUno es un numero
  if (isNaN(numeroUno)) {
    // no es un numero
    alert("Por favor introduce numero");
    repetir = confirm("Deseas repetir los calculos");
  } else {
    let numeroDos = Number(prompt("introduce numero 2"));
    if (isNaN(numeroDos)) {
      alert("Por favor introduce numero");
    } else {
      let suma = numeroUno + numeroDos;
      let resta = numeroUno - numeroDos;
      let multi = numeroUno * numeroDos;
      let div = numeroUno / numeroDos;
      let mod = numeroUno % numeroDos;
      alert(
        `El resultado de las operaciones es: \nsuma: ${suma}\nresta: ${resta}\n multi:${multi}\n div: ${div} \n mod: ${mod}  `
      );
    }
    repetir = confirm("Deseas repetir los calculos");
  }
} while (repetir);
