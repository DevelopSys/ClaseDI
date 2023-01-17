// fun nombre(para){}

function nombreFuncion(p1, p2) {
  console.log("Ejemplo de funcion a ejecutar");
  console.log(p1 + p2);
}

function funcionConRetorno(p1, p2) {
  return p1 + p2;
}

let funcionFlecha = (p1, p2) => {
  console.log(p1 + p2);
};

function parametrosAdiciones(p1) {
  console.log(p1);
  console.log("Invisibles");
  for (let i = 0; i < arguments.length; i++) {
    console.log(arguments[i]);
  }
}

function parametroDefecto(p1, p2, p3 = 7) {
  console.log(p1 + p2 + p3);
}

function parametroDefectoDesorden(p1 = 8, p2, p3 = 7) {
  console.log(p1 + p2 + p3);
}

function funcionCallback(operacion, p1, p2) {
  operacion(p1, p2);
}
/* funcionCallback(
  (p1, p2) => {
    console.log(p1 + p2);
  },
  6,
  9
);
funcionCallback(
  (p1, p2) => {
    console.log(p1 * p2);
  },
  6,
  9
); */
//parametroDefecto(4, 6);
//nombreFuncion(1, 2, 3, 4, 5, 6, 7);
//console.log(typeof funcionConRetorno(4, 5));
//funcionFlecha(1, 4);
//parametrosAdiciones(1, 2, 3, 4, "qweqweqweqwe");
setTimeout(() => {
  console.log("Ejecucion despues de empezar");
}, 4000);

setInterval(() => {
  console.log("Ejecucion con intervalo");
}, 2000);
