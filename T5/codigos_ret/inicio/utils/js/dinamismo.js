let botonPedir = document.querySelector("#boton-pedir");
// class id tag
let nodoPuntuacionJugador = document.querySelector("#puntuacion-j1");
let nodoNombreJugador = document.querySelector("#nombre-j1");
let nodoListaCartasJ1 = document.querySelector("div#cartas-j1");
let barajaCompleta = [];

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
  class='m-2 animate__animated animate__fadeInRight' style='width: 20%' >`;
  //let nodo = document.createElement("img");
  //nodoLI.className = "list-group-item";
  //nodoLI.textContent = `${cartaSacada}`;
  //nodo.src = `./utils/images/${cartaSacada}.png`;
  //nodoListaCartasJ1.appendChild(nodo);
});

setTimeout(() => {
  // ejecuta tras esperar
}, 100);