// generar un array baraja de cartas 1 - 13 C,D,T,P
// 1C 2C 3C 4C 5C 6C 1D 2D 3D
const palos = ["C", "T", "P", "D"];
let baraja = [];

// lista de los elementos que cumplan con el predicado

for (let i = 0; i < palos.length; i++) {
  for (let j = 1; j < 14; j++) {
    baraja.push(j + palos[i]);
  }
}

baraja = _.shuffle(baraja);

// todos los corazones -> lista de elementos
/* baraja
  .filter((item) => item.includes("C"))
  .forEach((item) => {
    console.log(item);
  }); */
// el elemento que cumple un predicado
/* baraja.forEach((element) => {
  console.log(element);
}); */
let elementoEncontrado = baraja.find((value) => {
  return value.includes("D");
});

// una baraja que no tenga el elemento 1C
let barajaSin1C = baraja.filter((item) => item != "1C");

barajaSin1C.forEach((element) => {
  console.log(element);
});
