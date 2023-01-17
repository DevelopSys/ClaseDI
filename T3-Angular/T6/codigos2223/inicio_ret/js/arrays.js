let elementosAny = [];
const elementosPalabra = ["Palabra 1", "Palabra 2", "Palabra 3", "Palabra 4"];

// obtener elementos
/* console.log(elementosPalabra[1]);
console.log(elementosPalabra[5]); */

// cambiar

/* elementosPalabra[0] = "Palabra 1 modificada";
elementosPalabra[2] = "Palabra 3";
elementosPalabra[10] = "Palabra 10"; */
// ["Palabra 1", "Palabra 2", "Palabra 3"]

//

/* elementosPalabra.forEach((element) => {
  console.log(element);
}); */

// añadir
elementosPalabra.push("Palabra nueva"); // -> 5
console.log(elementosPalabra.unshift("Palabra Inicio")); // -> 6

// eliminar
console.log(elementosPalabra.pop()); // palabra nueva
console.log(elementosPalabra.shift()); // Palabra inicial

elementosPalabra.forEach((element, index) => {
  console.log(`${index} ${element}`);
});
