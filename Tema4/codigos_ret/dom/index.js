let palos = ["C", "D", "T", "P"];
let baraja = [];
for (let index = 0; index < palos.length; index++) {
  const palo = palos[index];
  for (let index1 = 1; index1 < 14; index1++) {
    switch (index1) {
      case 11:
        baraja.push(new Carta(`J${palo}`));
        break;
      case 12:
        baraja.push(new Carta(`Q${palo}`));
        break;
      case 13:
        baraja.push(new Carta(`K${palo}`));
        break;
      default:
        baraja.push(new Carta(`${index1}${palo}`));
        break;
    }
  }
}
// console.log(baraja);
const boton = document.querySelector("#btn-sacar");

baraja = _.shuffle(baraja);

boton.addEventListener("click", (e) => {
  let cartaSacada = baraja.pop();
  if (cartaSacada != undefined) {
    cartaSacada.mostrarDatos();
    console.log(baraja);
  } else {
    alert("No hay mas carta");
  }
});
