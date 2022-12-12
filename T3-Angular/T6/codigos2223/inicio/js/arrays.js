let jugadores = [];

// AGREGAR DATOS
// agrega datos al final del array y obtengo la nueva longitud
jugadores.push("Jugador 1", "Jugador 2", "Jugador 3");
// agrega datos al principio del array y obtengo la nueva longitud
jugadores.unshift("Jugador nuevo", "Otro jugador");

// BORRAR DATOS
// borra elemento del final y lo retorna
//console.log(`Elemento borrado ${jugadores.pop()}`);
// borra elemento del principio y lo retorna
//console.log(`Elemento borrado ${jugadores.shift()}`);

// filtrar por una condicion indicada
/* let arrayResultante = [];
for (let index = 0; index < jugadores.length; index++) {
  if (!jugadores[index].includes("2")) {
    arrayResultante.push(jugadores[index]);
  }
} */

jugadores
  .filter((item) => !item.includes("2"))
  .forEach((item2) => {
    console.log(item2);
  });

console.log(
  jugadores.find((item) => {
    return item.includes("2");
  }).length
);

//console.log(jugadores);
