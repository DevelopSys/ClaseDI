let botonPedir = document.querySelector("#boton-pedir");
// class id tag
let nodoPuntuacionJugador = document.querySelector("#puntuacion-j1");
let barajaCompleta = [];

iniciarBajara();
botonPedir.addEventListener("click", () => {
  let cartaSacada = barajaCompleta.pop();
  // asignar el valor de la variable dentro del html del nodo
  //nodoPuntuacionJugador.innerHTML = contadorJ1;
  nodoPuntuacionJugador.innerText =
    Number(nodoPuntuacionJugador.textContent) + 1;
  console.log(cartaSacada);
});

function iniciarBajara() {
  const palos = ["C", "D", "P", "R"];
  for (let i = 0; i < palos.length; i++) {
    for (let j = 1; j < 14; j++) {
      barajaCompleta.push(`${j}${palos[i]}`);
    }
  }
  barajaCompleta = _.shuffle(barajaCompleta);
}
