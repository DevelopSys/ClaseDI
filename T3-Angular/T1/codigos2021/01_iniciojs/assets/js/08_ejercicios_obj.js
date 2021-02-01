let barcelona = { nombre: "barcelona", posicion: 1, plantilla: [] };
let madrid = { nombre: "madrid", posicion: 2, plantilla: [] };
let atleti = { nombre: "atleti", posicion: 3, plantilla: [] };

let equiposLaLiga = [barcelona, madrid, atleti];

function addJugador(nombre, posicion, valor, equipo) {
  let jugador = { nombre, posicion, valor };

  //console.log(jugador);

  switch (equipo) {
    case "barcelona":
      barcelona.plantilla.push(jugador);
      break;
    case "madrid":
      madrid.plantilla.push(jugador);
      break;
    case "atletico":
      atleti.plantilla.push(jugador);
      break;

    default:
      console.log("No se reconoce el equipo");
      break;
  }
}
addJugador("Messi", "Delantero", 10000, "barcelona");
addJugador("DeJong", "Medio", 10000, "barcelona");
addJugador("Pique", "Defensa", 10000, "barcelona");
addJugador("Suarez", "Delantero", 10000, "atletico");
addJugador("Vini", "Delantero", 10000, "madrid");

let metodos = {
  listarEquipo: (equipo) => {
    // sacar los datos del equipo
    // console.log(equiposLaLiga.equipo);
    equiposLaLiga.forEach((team) => {
      if (team.nombre === equipo) {
        console.log(team);
      }
    });
  },
  listarPlantilla: (equipo) => {
    equiposLaLiga.forEach((team) => {
      if (team.nombre === equipo) {
        //console.log(team);
        team.plantilla.forEach((player) => {
          console.log(player);
        });
      }
    });
  },
};

//metodos.listarEquipo("madrid");
metodos.listarPlantilla("barcelona");
