"use strict";
/*console.log('hola mundo');
console.log('Esto es un ejemplo de linea de codigo')
console.log('Esto es un nuevo cambio');
let numero:number = 1;
let palabra:string='1';
console.log(numero);*/
var nombre = "Borja";
var apellido = "Martin Herrera";
// console.log(nombre+' '+apellido)
console.log(nombre + " " + apellido);
var nota = 1;
/*if (nota >= 5) {
    console.log('Has aprobado');
} else if (nota < 5 && nota > 2) {
    console.log('Has suspendido');
} else {
    console.log('fatal')
}*/
switch (nota) {
    case 1:
        console.log("caso 1");
        break;
    case 2:
        console.log("caso 2");
        break;
    default:
        console.log("Resto de casos");
        break;
}
/*for (let index = 0; index < 10; index++) {
    console.log(`Elemento ${indeconjuntoPaab*/
var conjuntoPalabras = ["primera", "segundo", "tercero", "cuarto"];
console.log("con forin");
for (var key in conjuntoPalabras) {
    console.log(conjuntoPalabras[key]);
}
console.log("con forof");
for (var _i = 0, conjuntoPalabras_1 = conjuntoPalabras; _i < conjuntoPalabras_1.length; _i++) {
    var iterator = conjuntoPalabras_1[_i];
    console.log(iterator);
}
console.log("con foreach arrow");
conjuntoPalabras.forEach(function (element) {
    console.log(element);
});
console.log("funciones");
function funcionInicial(nombre) {
    console.log(nombre);
}
function funcionInicialParametros(nombre, apellido, edad) {
    console.log(nombre + " " + apellido + " " + edad);
}
function funcionRetorno(numeroUno, numeroDos) {
    return numeroUno + numeroDos;
}
function funcionCualquierParamentro(params) {
    console.log(params);
}
function funcionParamentesMultiples(nombre) {
    var nombresMultiples = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        nombresMultiples[_i - 1] = arguments[_i];
    }
    console.log(nombre);
    if (nombresMultiples.length > 0) {
        nombresMultiples.forEach(function (element) {
            console.log(element);
        });
    }
    else {
        console.log('no han pasado paramentros multiples');
    }
}
function funcionParamentrosMultiples(nombre, nombresMultiple) {
}
function funcionParametrosOptativos(nombre, apellido, edad) {
    if (edad == null) {
        console.log(nombre + " " + apellido);
    }
    else {
        console.log(nombre + " " + apellido + " " + edad);
    }
}
function funcionValoresDefecto(nombre, apellido) {
    if (apellido === void 0) { apellido = 'defecto'; }
    console.log(nombre + " " + apellido);
}
funcionInicial("MiNombre");
funcionInicialParametros("Borja", "Martin", 123);
console.log(funcionRetorno(44, 53));
funcionCualquierParamentro("asd");
funcionCualquierParamentro(123);
funcionCualquierParamentro(true);
funcionParamentesMultiples('Borja', 'asd', 'iytre', 'uytre');
var ejemploNombresArray = [""];
funcionParamentrosMultiples('Borja', ejemploNombresArray);
funcionParametrosOptativos('Borja', 'Martin');
funcionParametrosOptativos('Borja', 'Martin', 345);
funcionValoresDefecto('Borja', 'Martin');
