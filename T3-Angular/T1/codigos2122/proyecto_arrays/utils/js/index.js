// array
let alumnos = [];

console.log(alumnos.length);
// agrega al final del array
alumnos.push(1);
alumnos.push(2);
alumnos.push(3, 4, 5, 6, 7, 8, 9, 0);
console.log(alumnos);

// elimina del final del array
alumnos.pop();
console.log(alumnos);

// agrega elementos al principio del array
alumnos.unshift(0, 9, 8, 7, 6, 5, 4, 3, 2, 1);
console.log(alumnos);

// elimina elementos del principio
alumnos.shift();
console.log(alumnos);

/*for (let index = 0; index < alumnos.length; index++) {
    console.log(alumnos[index]);
}*/

console.log("Impresion por foreach");
alumnos.forEach((element, pos) => {
  if (pos%2 == 0){
    console.log(`${pos} - ${element}`);
  } 
});

alumnos[4] = 099
