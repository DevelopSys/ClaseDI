const baraja = ["1D", "1C", "2C", "3C", "4C", "5C"];
// baraja.length
// console.log(baraja[5]);
// baraja[5] = "6C";
baraja.push("6C", "7C", "8C");
baraja.unshift("0C");
// 0C - 8C
baraja.pop();
// 0C - 7C
baraja.shift();
// 1C - 7C
// sacar todos los elementos de un array
baraja.forEach((element, index) => {
  if (element.includes("D")) {
    console.log(`${index + 1} ${element}`);
  }
});

// Hacer una baraja francesa
// 1C - 13C
// 1D - 13D
// 1P - 13P
// 1R - 13R
//console.log(baraja);
const palos = ["C", "D", "P", "R"];
const barajaCompleta = [];

for (let i = 0; i < palos.length; i++) {
  for (let j = 1; j < 14; j++) {
    barajaCompleta.push(`${j}${palos[i]}`);
  }
}

console.log(barajaCompleta);

/*
Preguntar al usuario cuantas cartas quiere sacar: 20
Barajar la baraja

Sacar las cartas que diga el usuario y obtener:
- cuantas cartas don de C / R / P / D
- cuenta de dichas cartas

*/
