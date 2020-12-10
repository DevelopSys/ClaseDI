// comentarios
/** 
 comentarios
*/
console.log("Esto es un ejemplo de llamada js externa");

const variableConstanteNumero = 2;
const variableConstanteLetra = "Letra";
const variableConstanteFloat = 5.6;
const variableConstanteBoolean = false;
const variableConstanteUndefined = undefined;
const variableConstanteArray = [];

console.log("La constante numero es: " + variableConstanteNumero);
console.log(`La constante letra es: ${variableConstanteLetra}`);

// tipos number, string , booleam , undefined , NaN

console.log(
  "El tipo de la constatnte Numero es " + typeof variableConstanteNumero
);
console.log(
  "El tipo de la constatnte Float es " + typeof variableConstanteFloat
);
console.log(
  "El tipo de la constatnte Boolean es " + typeof variableConstanteBoolean
);
console.log(
  "El tipo de la constatnte Letra es " + typeof variableConstanteLetra
);
console.log(
  "El tipo de la constatnte undefined es " + typeof variableConstanteUndefined
);
console.log(
  `El tipo de la constatnte undefined es ${typeof variableConstanteUndefined}`
);

// IF

let numero = "-7";

if (numero < 0 || numero > 10) {
  console.log("El numero no es valido");
} else {
  if (numero < 5) {
    console.log("Suspenso");
  } else {
    console.log("Aprobado");
  }
}

// SWITCH
let opcion = 6;

switch (opcion) {
  case 1:
    console.log("Opcion 1 seleccionada");
    break;
  case 2:
    console.log("Opcion 2 seleccionada");
    break;
  case 3:
    console.log("Opcion 3 seleccionada");
    break;
  default:
    console.log("Caso no contemplado");
    break;
}

// WHILE

//while (condition) {}

// DOWHILE

//do {} while (condition);

// FOR

/*for (let index = 0; index < 10; index++) {
  console.log(`Opcion ${index}`);
}*/

let coleccion = ["hola", "que", "tal", "estas", "muy", "bien"];

//console.log(coleccion[5]);

/*for (let index = 0; index < coleccion.length; index++) {
  console.log(coleccion[index]);
  //alert(coleccion[index]);
}

coleccion.forEach((item) => {
  console.log(item);
});*/

/*console.log("FOR IN");

for (const key in coleccion) {
  console.log(coleccion[key]);
}

console.log("FOR OF");

for (const iterator of coleccion) {
  console.log(iterator);
}*/

// añado a un array
console.log(`La longitud del array antes de añadir es ${coleccion.length}`);
coleccion.push("as", "asdasd", "aewg", "asdasda");
coleccion.forEach((element) => {
  console.log(element);
});
console.log(`La longitud del array despues de añadir es ${coleccion.length}`);

// sacar las palabras que tienen 5 o más letras
