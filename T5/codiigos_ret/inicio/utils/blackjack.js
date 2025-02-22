let botonPedir = document.querySelector("#pedirCarta");
const palos = ["C", "D", "T", "P"];
// baraja -> 1C K CDPT 12345678910JQK
let baraja = [];
let puntuacion = 0;

function iniciarBaraja() {
  puntuacion = 0;
  baraja = [];
  for (let i = 0; i < palos.length; i++) {
    for (let j = 1; j <= 13; j++) {
      if (j == 11) {
        baraja.push(new Carta(`J${palos[i]}`));
      } else if (j == 12) {
        baraja.push(new Carta(`Q${palos[i]}`));
      } else if (j == 13) {
        baraja.push(new Carta(`K${palos[i]}`));
      } else {
        baraja.push(new Carta(`${j}${palos[i]}`));
      }
    }
  }
  baraja = _.shuffle(baraja);
}

function obtenerValorCarta(carta) {
  return carta.valor;
}

function obtenerImagenCarta(carta) {
  return carta.imagen;
}

function pedirCarta() {
  let carta = baraja.pop();
  //let valor = obtenerValorCarta(carta);
  // let imagen = obtenerImagenCarta(carta);
  if (puntuacion == 21) {
    // ganado
    Swal.fire({
      title: "Resultado",
      text: "Enhorabuena, has ganado el juego",
      icon: "sucess",
    });
  } else if (puntuacion > 21) {
    Swal.fire({
      title: `Lo siento has persido con una puntuación de ${puntuacion}. Quieres volver a jugar?`,
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: "SI",
      denyButtonText: `NO`,
    }).then((result) => {
      if (result.isConfirmed) {
        iniciarBaraja();
      } else if (result.isDenied) {
        Swal.fire({
          title: "Resultado",
          text: `Gracias por participar`,
          icon: "warning",
        });
        iniciarBaraja();
      }
    });
  } else {
    Swal.fire({
      imageUrl: `./utils/images/${imagen}.png`,
      title: `Tu puntuacion es de ${puntuacion}, ¿Quieres sacar más cartas?`,
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: "SI",
      denyButtonText: `NO`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        pedirCarta();
      } else if (result.isDenied) {
        Swal.fire({
          title: "Resultado",
          text: `Tu puntuación final es de ${puntuacion}}`,
          icon: "warning",
        });
        iniciarBaraja();
      }
    });
  }
}

iniciarBaraja();

botonPedir.addEventListener("click", (e) => {
  pedirCarta();
});

/* let correo =  "borja@gmail.com"
correo.charAt(1) // caracter en la posicion correspondiente
correo.split('@') // [asdasdasd,asdasdasd]
correo.substring(3,7) */
