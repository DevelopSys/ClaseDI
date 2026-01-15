let alumnos = ["Borja", "Maria", "Luis"];

// insertar elementos
// alumnos[9] = "Pedro"
alumnos.push("Pedro", "Jose", "Marta"); // retorna el numero de elementos de la lista
alumnos.unshift("Cesar", "Celia", "Pepe"); // retorna el numero de elementos de la lista

// "Cesar", "Celia", "Pepe","Borja", "Maria", "Luis","Pedro", "Jose", "Marta"
// eliminar elementos
alumnos.pop(); // elimina el ultimo elemento de la lista y lo retorna
alumnos.shift(); // elimina el primer elemento de la lista y lo retorna

// "Celia", "Pepe","Borja", "Maria", "Luis","Pedro", "Jose"
alumnos = _.shuffle(alumnos);
console.log(alumnos);

// consultar elementos
// alumnos[4]
/* for (let index = 0; index < alumnos.length; index++) {
  const element = alumnos[index];
  console.log(element);
} */
// item,index,list
/* alumnos.forEach((data, index) => {
  if (index % 2 == 0) {
    console.log(`${index} - ${data}`);
  }
}); */
// item,index,list
/* let alumnoEncontrado = alumnos.find((data) => {
  // logica
  return data == "Maria";
}); */
// let alumnoEncontrado = alumnos.find((data) => data == "Maria");
// let alumnosEncontados = alumnos.filter((data) => data.length > 5);
// alumnosEncontados.forEach((item) => console.log(item));
let palabra = "borja@gmail.com"
// palabra.charAt(4)
palabra.substring()
