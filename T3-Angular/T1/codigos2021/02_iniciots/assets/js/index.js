// tipado de variables
var nombre = "Borja";
var numero = 6;
var acierto = false;
var arrayDatos = ["asd", "asd", "asd"];
var arrayCosas = ["add", false, 3, "s"];
var arrayNumeros = [1, 2, 3, 4, 5];
var variableFuncion = function () {
    console.log("funcion ejecutada");
};
function funcionParametros(nombre, edad) {
    console.log(nombre + " " + edad);
}
function funcionRetorno(opUno, opDos, operacion) {
    var resultado = 0;
    switch (operacion) {
        case "suma":
            resultado = opUno + opDos;
            break;
        case "resta":
            resultado = opUno - opDos;
            break;
        case "multi":
            resultado = opUno * opDos;
            break;
        case "div":
            resultado = opUno / opDos;
            break;
    }
    return resultado;
}
function funcionParamentrosMultiples(parametroObligatorio) {
    var paramMultiOpta = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        paramMultiOpta[_i - 1] = arguments[_i];
    }
    console.log("Funcion ejecutada");
    // si hay parametros multiples los imprime por consola: los parametros multiples son--------
    // si no hay parametros multiples imprieme: no hay multiples
    console.log(paramMultiOpta.length);
    if (paramMultiOpta.length > 0) {
        console.log("Hay parametros multiples");
        paramMultiOpta.forEach(function (element) {
            console.log(element);
        });
    }
    else {
        console.log("No hay parametros multiples");
    }
}
function funcionParamentrosMultiplesTodos(paramUno) {
    var paramOptaMult = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        paramOptaMult[_i - 1] = arguments[_i];
    }
}
function funcionOptativos(nombre, edad, altura) {
    // altura != undefined
    if (altura) {
        console.log(nombre + " " + edad + " " + altura);
    }
    else {
        console.log(nombre + " " + edad);
    }
}
function funcionParametosDefecto(nombre, apellido, edad) {
    if (edad === void 0) { edad = 18; }
    console.log(nombre + " " + apellido + " " + edad);
}
funcionParametosDefecto("Borja", "Martin", 36);
//funcionOptativos("Borja", 35, 170);
//console.log(`${nombre} ${numero}`);
//variableFuncion();
//funcionParametros("Borja", 23);
//funcionParametros(23, "Borja");
//funcionParametros();
console.log("La suma de dos parametros " + funcionRetorno(4, 2, "suma") + " y " + funcionRetorno(4, 2, "multi") + " es " + (funcionRetorno(4, 2, "suma") + funcionRetorno(4, 2, "multi")));
/*funcionParamentrosMultiples(
  false,
  "kjghf",
  "asdasd",
  "asdasdasdasd",
  "wqeqweqwe",
  "tryrty"
);*/
//funcionParamentrosMultiples(false);
// condicion ? loquepasasiestrue : loqueasasiesfalse
//funcionParamentrosMultiples(false, 1, 2, 3, 4, 5, 6, 7);
