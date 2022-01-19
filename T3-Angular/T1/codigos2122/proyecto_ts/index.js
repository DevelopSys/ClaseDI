var numero = 7;
var palabra = "ejemplo";
var array = [1, 2, 34, 5, 6];
console.log("".concat(palabra));
function funcionParamentros(numero) {
    console.log(numero);
}
function funcionConRetorno(numeroUno, numeroDos) {
    var resultado = numeroUno + numeroDos;
    return resultado;
}
function funcionParamentrosOptativos(numero, palabra, acierto) {
    console.log(numero);
    console.log(palabra);
    console.log(acierto);
}
function funcionParametrosAdicionales(params) {
    var parametroArray = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        parametroArray[_i - 1] = arguments[_i];
    }
    parametroArray.forEach(function (element) {
    });
}
function funcionParamentrosDefecto(params, param2) {
    if (param2 === void 0) { param2 = 'por defecto'; }
}
funcionParamentros(123456);
console.log(funcionConRetorno(123, 123));
funcionParamentrosOptativos(1, "asd");
funcionParametrosAdicionales(9, 123, 123, 423, 423, 543, 6, 457, 587, 678, 4, 35, "weqwe", false);
funcionParamentrosDefecto(1, "asdasd");
