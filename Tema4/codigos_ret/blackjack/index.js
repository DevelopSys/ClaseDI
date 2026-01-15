let palos = ["C", "D", "T", "P"];
let baraja = [];
/* 1C
2C
3C
4C
1D
2D
3D
4D */
for (let index = 0; index < palos.length; index++) {
  const palo = array[palos];
  for (let index1 = 1; index1 < 14; index1++) {
    switch (index1) {
      case 11:
        break;
      case 12:
        break;
      case 13:
        break;
      default:
        baraja.push(`${index1}${palo[index]}`);
        break;
    }
  }
}
