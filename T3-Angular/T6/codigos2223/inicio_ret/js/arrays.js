let elementosAny = [];
const elementosPalabra = ["Palabra 1", "Palabra 2"];

// obtener elementos
console.log(elementosPalabra[1]);
console.log(elementosPalabra[5]);

// cambiar

elementosPalabra[0] = "Palabra 1 modificada";
elementosPalabra[2] = "Palabra 3";
elementosPalabra[10] = "Palabra 10";
// ["Palabra 1", "Palabra 2", "Palabra 3"]

for (const key in elementosPalabra) {
  console.log(key);
}

elementosPalabra.length = 100;
console.log(elementosPalabra.length);

elementosPalabra.forEach((element) => {
  console.log(element);
});
/* elementosPalabra.forEach((element) => {
  console.log(element);
}); */

// añadir

// eliminar
