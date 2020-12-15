let objetoInicial = {
  prop1: "valor",
  prop2: 123,
  prop3: false,
  prop4: ["uno", "dos", "tres"],
  prop5: { p1: "asd", p2: "dasdasdasdasd" },
};

console.log(`La pripiedad 1 es ${objetoInicial.prop1}`);
console.log(`La pripiedad 2 es ${objetoInicial.prop2}`);
console.log(`La pripiedad 3 es ${objetoInicial.prop3}`);
//console.log(`La pripiedad 4 es ${objetoInicial.prop4}`);
objetoInicial.prop4.forEach((element, index) => {
  console.log(`La propiedad del array ${index + 1} es ${element}`);
});

//console.log(objetoInicial.prop5);
console.log(`La pripiedad 5 es ${objetoInicial.prop5.p1}`);
console.log(`La pripiedad 5 es ${objetoInicial.prop5.p2}`);

objetoInicial.prop1 = "sdasdasdasd";
console.log(objetoInicial);

let calculadora = {
  sumar: function (p1, p2) {
    console.log(`La suma de los parámetros es ${p1 + p2}`);
  },
  restar: (p1, p2) => {
    console.log(`La resta de los parámetros es ${p1 - p2}`);
  },
  multiplicar: (p1, p2) => {
    console.log(`La multiplicación de los parámetros es ${p1 * p2}`);
  },
  dividir: (p1, p2) => {
    console.log(`La división de los parámetros es ${p1 / p2}`);
  },
};

//calculadora.sumar(1, 6);
//calculadora.restar(4, 2);
//calculadora.multiplicar(2, 6);
//calculadora.dividir(5, 3);

function operar(num1, num2, operacion) {
  operacion(num1, num2);
  // calculadora.dividir(1,2)
}

operar(1, 2, calculadora.dividir);

// Coche c = new Coche("asd","asd",123,new Motor());
// c.getMarca();
// class Coche {
// String marca:
//
//}
