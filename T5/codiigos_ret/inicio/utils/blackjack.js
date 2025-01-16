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
  // sacar por sweetAlert la carta que saca, indicando por separado!!!
  // el palo y el valor de la carta
  // 1,2,3,4,5,6,7,8,9,10
  // J,!,K -> 10
  // console.log("Boton pulsado correctamente");
  let cartaSacada = baraja.pop();
  let valor = cartaSacada.substring(0, cartaSacada.length - 1);
  let palo = cartaSacada.substring(cartaSacada.length - 1);
  console.log(`La carta sacada es ${cartaSacada}`);
  console.log(`Su valor es ${valor}`);
  console.log(`Su valor es ${palo}`);
});

/* let correo =  "borja@gmail.com"
correo.charAt(1) // caracter en la posicion correspondiente
correo.split('@') // [asdasdasd,asdasdasd]
correo.substring(3,7) */
