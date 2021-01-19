function primeraFuncion() {
  console.log("Ejecución de la primera función");
}

let funcionAnonima = function () {
  console.log("Esto es una ejecución desde función anónima");
};

let funcionFlecha = () => {
  console.log("Ejecución desde función de flecha");
};

function funcionParametros(parametroUno, parametroDos, parametroTres) {
  console.log(`${parametroUno} ${parametroDos} ${parametroTres}`);
}

function funcionParamentrosArguments() {
  console.log("La función se ha ejecutado");
  if (arguments.length > 0) {
    for (let index = 0; index < arguments.length; index++) {
      const element = arguments[index];
      console.log(element);
    }
  }
}

function funcionPorDefecto(parametroUno, parametroDos = 0) {
  console.log(`La suma de las dos cosas es ${parametroUno + parametroDos} `);
}

function funcionRetorno(parametroUno = 10, parametroDos = 0) {
  let resultado = parametroUno + parametroDos;
  return resultado;
}

let funcionFlechaParam = (param1, param2) => {
  return 6;
};

function funcionConCallBack(nombre, apellido, edad, peso, funcionParametro) {
  console.log(`${nombre} ${apellido}`);
  funcionParametro(edad, peso);
}

function funconConCallBackRetorno(n1, n2) {
  return (paramentroNuevo) => {
    console.log(`La suma de los dos parametros es ${n1 + n2}`);
    console.log(`El parámetro nuevo es ${paramentroNuevo}`);
  };
}
setInterval(() => {
  console.log("ejecucion por paramtro en intervalo");
}, 2000);

setTimeout(() => {
  console.log("ejecucion por parametro");
}, 3000);

/*function sumaConstntes(edad, peso) {
  console.log(`La suma de los parametros es ${edad + peso}`);
}

function mostrarContantes(edad, peso) {
  console.log(`Sus valores vitales son ${edad} ${peso}`);
}*/

/*primeraFuncion();
funcionAnonima();
funcionParametros(1, "Hola", false);
funcionParametros(1, "Hola", false, 34, 34, 123, 123, false);
funcionParamentrosArguments("parametro1", "parametro2", 3, false);
funcionPorDefecto(1, 7);
console.log(funcionRetorno(15, 9));
//funcionFlechaParam(2, 3);
console.log(funcionFlechaParam(123, 123));*/
/*funcionConCallBack("Borja", "Martin", 20, 70, (n1, n2) => {
  console.log(`La suma de los parametros es ${n1 + n2}`);
});

funcionConCallBack("Borja", "Martin", 34, 180, (n1, n2) => {
  console.log(`Sus valores vitales son ${n1} ${n2}`);
});*/

funconConCallBackRetorno(1, 2)("Nueva comunicación");
