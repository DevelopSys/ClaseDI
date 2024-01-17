// import

let jugador1 = new Jugador("Borja");
let jugador2 = new Jugador("Banca");
let barajaCompleta = [];

function iniciarBajara() {
  const palos = ["C", "D", "P", "T"];
  for (let i = 0; i < palos.length; i++) {
    for (let j = 1; j < 14; j++) {
      let carta = new Carta(`${j}${palos[i]}`);
      if (carta.valor > 9) {
        carta.valor = 10;
      }
      barajaCompleta.push(carta);
    }
  }
  barajaCompleta = _.shuffle(barajaCompleta);
  console.log(barajaCompleta);
}
// crear la baraja
iniciarBajara();

console.log(`Los puntos de ${jugador1.nombre} son ${jugador1.puntos}`);
