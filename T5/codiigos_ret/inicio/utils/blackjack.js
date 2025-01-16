let botonPedir = document.querySelector("#pedirCarta");
// baraja -> 1C K CDPT 12345678910JQK
let baraja = [];
const palos = ["C", "D", "T", "P"];
for (let i = 0; i < palos.length; i++) {
  for (let j = 1; j <= 13; j++) {
    if (j == 11) {
      baraja.push(`J${palos[i]}`);
    } else if (j == 12) {
      baraja.push(`Q${palos[i]}`);
    } else if (j == 13) {
      baraja.push(`K${palos[i]}`);
    } else {
      baraja.push(`${j}${palos[i]}`);
    }
  }
}

/* for (let index = 0; index < 50; index++) {
  let n1 = parseInt(Math.random() * 50);
  let n2 = parseInt(Math.random() * 50);
  let temporal = baraja[n2];
  baraja[n2] = baraja[n1];
  baraja[n1] = temporal;
} */
baraja = _.shuffle(baraja);

botonPedir.addEventListener("click", (e) => {
  console.log("Boton pulsado correctamente");
});
