// funcion es un metodo
// function nombre(param){} -> "normales"
// (a)=>{asdasdasdasd} -> variables

saludar("Borja");
console.log(`La suma de los dos numeros es ${sumar(4, 10)}`);
sumaFantasma(10, 2, 3, 4, 5, 6, 7, 8, 9, 10);

function saludar(nombre) {
  console.log(`Hola ${nombre}`);
}

function sumar(p1, p2 = 0) {
  return p1 + p2;
}

function sumaFantasma() {
  let suma = 0;
  for (let index = 0; index < arguments.length; index++) {
    suma += arguments[index];
  }
  /*   arguments.forEach((item) => {
    suma += item;
    }); */
  console.log(`La suma total de los fantasmas es de ${suma}`);
}

let sumaFlecha = (p1, p2) => {
  console.log(`La suma flecha de los elementos ${p1} y ${p2} es ${p1 + p2}`);
};

let sumaFlechaRetorno = (p1, p2) => p1 + p2;

// sumaFlecha(1, 4);
console.log(`La sumaflecha con retorno es ${sumaFlechaRetorno(1, 6)}`);
