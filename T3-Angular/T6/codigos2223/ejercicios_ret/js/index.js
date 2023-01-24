let equipoMadrid = new equipo("Madrid", 100000);
let equipoBarcelona = new equipo("Barcelona", 200000);
let equipoAtletico = new equipo("Atletico", 300000);

equipoMadrid.addJugador(new jugador("vinicius", "Delantero", 50000));
equipoMadrid.addJugador(new jugador("vallejo", "Defensa", 10000));
equipoBarcelona.addJugador(new jugador("padri", "medio", 10000));
equipoAtletico.addJugador(new jugador("griezmann", "Delantero", 10000));

/* setTimeout(() => {
  equipoMadrid.addJugador(new jugador("benzema", "Delantero", 50000));
}, 5000); */

//equipoMadrid.listaPlantilla();

let liga = [equipoAtletico, equipoBarcelona, equipoMadrid];

liga.forEach((element) => {
  element.listarPosicion("Delantero");
});
