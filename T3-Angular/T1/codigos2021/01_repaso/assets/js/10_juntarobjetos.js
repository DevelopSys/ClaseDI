let cristiano = new Jugador("Cristiano", "Ronaldo", "Delantero");
let messi = new Jugador("Messi", "Messii", "Delantero");
let suarez = new Jugador("Luis", "Suarez", "Delantero");

function mostrarJugadores(j1, j2, j3) {
  j1.mostrarDatos();
  j2.mostrarDatos();
  j3.mostrarDatos();
}

mostrarJugadores(cristiano, messi, suarez);
