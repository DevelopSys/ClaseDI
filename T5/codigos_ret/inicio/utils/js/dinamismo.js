let botonPedir = document.querySelector("#boton-pedir");
let botonPasar = document.querySelector("#boton-pasar");
// class id tag
let nodoPuntuacionJugador = document.querySelector("#puntuacion-j1");
let nodoPuntuacionBanca = document.querySelector("#puntuacion-j2");
let nodoNombreJugador = document.querySelector("#nombre-j1");
let nodoListaCartasJ1 = document.querySelector("div#cartas-j1");
let barajaCompleta = [];
let contador = 1;

function iniciarBajara() {
  const palos = ["C", "D", "P", "T"];
  for (let i = 0; i < palos.length; i++) {
    for (let j = 1; j < 14; j++) {
      barajaCompleta.push(`${j}${palos[i]}`);
    }
  }
  barajaCompleta = _.shuffle(barajaCompleta);
}
function configurarNombre() {
  let nombreJugador = prompt("Indica tu nombre");
  nodoNombreJugador.innerText = nombreJugador;
}

window.addEventListener("load", () => {
  //configurarNombre();
  iniciarBajara();
});

botonPedir.addEventListener("click", () => {
  let cartaSacada = barajaCompleta.pop();
  // 4C
  // 13C

  let valorCarta = cartaSacada.substring(0, cartaSacada.length - 1);
  if (Number(valorCarta) > 9) {
    valorCarta = 10;
  }
  nodoPuntuacionJugador.innerText =
    Number(nodoPuntuacionJugador.textContent) + Number(valorCarta);

  nodoListaCartasJ1.innerHTML += `<img src='./utils/images/${cartaSacada}.png' 
    class='m-2' style='width: 20%' >`;

  setTimeout(() => {
    if (Number(nodoPuntuacionJugador.textContent) == 21) {
      // no puedo pedir mas
      botonPedir.disabled = true;
    } else if (Number(nodoPuntuacionJugador.textContent) > 21) {
      alert("Has perdido");
    }
  }, 200);

  //let nodo = document.createElement("img");
  //nodoLI.className = "list-group-item";
  //nodoLI.textContent = `${cartaSacada}`;
  //nodo.src = `./utils/images/${cartaSacada}.png`;
  //nodoListaCartasJ1.appendChild(nodo);
});

botonPasar.addEventListener("click", () => {
  // la banca va sacando

  do {
    setInterval(() => {
      let cartaSacada = barajaCompleta.pop();
      let valorCarta = cartaSacada.substring(0, cartaSacada.length - 1);
      nodoPuntuacionBanca.textContent =
        Number(nodoPuntuacionBanca.textContent) + Number(valorCarta);
      console.log(cartaSacada);
    }, 2000);
  } while (Number(nodoPuntuacionBanca.textContent) < 17);
});
