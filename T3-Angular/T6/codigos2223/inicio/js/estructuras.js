// estructuras de control

/* if (condition) {
} else {
}

true ? console.log("cuando true") : console.log("cuando false");
true & console.log("cuando true");
// if else if else
true
  ? console.log("cuando true")
  : true
  ? console.log("verdad la segunda")
  : console.log("false la sengunda");

let valor = 5;
switch (valor) {
  case 1:
    break;
  case 2:
    break;
  case 3:
    break;
  case 4:
    break;
  default:
    break;
}

while (numero > 10) {
  numero--;
}

do {
  numero--;
} while (numero > 10);
 */

/* for (let index = 0; index < array.length; index++) {

} */

let elementos = ["Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"];
/* elementos.forEach((item, posicion, array) => {
  //console.log(`${posicion} ${item}`);
  //console.log(array);
  if (posicion % 2 == 0) {
    console.log(`${posicion} ${item}`);
  }
}); */

elementos.forEach((element) => {
  console.log(element);
});

// for (String item: coleccion)
/* for (const item of elementos) {
  console.log(item);
} */

/* for (const key in elementos) {
  console.log(key);
} */
