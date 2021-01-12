console.log("ejecucion desde operaciones");
let numeroUno = 3; // number
let numeroUnoString = "3"; // string
let numeroDos = 4;
let acierto = true;
let fallo = false;
// operaciones
/*numeroDos++;
numeroUno--;
let suma = numeroUno + numeroDos;
console.log(suma);

let sumaNumero = 5;
sumaNumero += numeroUno;*/

// comparadores

let comparacion = numeroUno < numeroDos;
console.log(comparacion);
let comparacionIgualdad = numeroUno != numeroUnoString;
console.log(comparacionIgualdad);

// relaciones logicas
// AND
let comparacionLogicaAND = numeroUno > 0 && numeroUno == numeroDos;
console.log(comparacionLogicaAND);
let comparacionLogicaOR = numeroUno > 0 || numeroUno == numeroDos;
console.log(comparacionLogicaOR);

// operadores de objeto
// new .
let fecha = new Date();
console.log(fecha.setMonth(-7));

// operador colecciones
// []
let arrayNumeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(arrayNumeros);
