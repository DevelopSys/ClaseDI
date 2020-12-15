let jugadoresBarsa = [];
let jugadoresMadrid = [];
let jugadoresAtletico = [];

let barsa = { nombre: "Barsa", posicion: 2, plantilla: jugadoresBarsa };
let madrid = { nombre: "Madrid", posicion: 3, plantilla: jugadoresMadrid };
let atleti = { nombre: "Atleti", posicion: 1, plantilla: jugadoresAtletico };

//console.log(barsa.plantilla[0].posicion + " " + barsa.plantilla[0].nombre);

function addJugador(nombreJ, posicionJ, valorJ, equipoJ) {
  let jugador = { nombre: nombreJ, posicion: posicionJ, valor: valorJ };
  if (equipoJ == "Barsa") {
    jugadoresBarsa.push(jugador);
  } else if (equipoJ == "Madrid") {
    jugadoresMadrid.push(jugador);
  } else if (equipoJ == "Atleti") {
    jugadoresAtletico.push(jugador);
  } else {
    console.log("No existe este equipo");
  }
}

addJugador("Messi", "Delantero", 0, "Barsa");
addJugador("Ansu", "Delantero", 1, "Barsa");
addJugador("Pique", "Defensa", 2, "Barsa");

let metodos = {
  listarEquipo: (equipo) => {
    /*console.log(`El nombre del equipo es: ${equipo.nombre}`);
    console.log(`La posició del equipo es: ${equipo.posicion}`);*/

    console.log(
      `El equipo es: ${equipo.nombre} y su posición es: ${equipo.posicion}`
    );
  },
  listarPlantilla: (equipo) => {
    if (equipo.plantilla.length == 0) {
      console.log("No hay jugadores en la plantilla");
    } else {
      equipo.plantilla.forEach((element) => {
        console.log(
          `Nombre: ${element.nombre} Posicion: ${element.posicion} Valor: ${element.valor}`
        );
      });
    }
  },
};

metodos.listarEquipo(madrid);
metodos.listarPlantilla(barsa);
