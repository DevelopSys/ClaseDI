let elementos = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "Opcion"];

/* for (let index = 0; index < elementos.length; index++) {
  console.log(elementos[index]);
} */

/* for (const iterator of elementos) {
    
} */

/* for (const key in elementos) {

} */

elementos.forEach((item, index) => {
  index % 2 == 0 && console.log(item);
});
