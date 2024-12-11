"use strict";
let boton = document.querySelector("#boton-agregar");
let inputTitulo = document.querySelector("#input-titulo");
let inputDescripcion = document.querySelector("#input-descripcion");
let selectPrioridad = document.querySelector("#select-prioridad");
let parrafo = document.querySelector("#parrafo-principal");
// EVENTOS
boton === null || boton === void 0 ? void 0 : boton.addEventListener("click", (e) => {
    console.log(e);
});
selectPrioridad === null || selectPrioridad === void 0 ? void 0 : selectPrioridad.addEventListener("change", (e) => {
    console.log(e);
});
inputDescripcion === null || inputDescripcion === void 0 ? void 0 : inputDescripcion.addEventListener("keyup", (e) => {
    parrafo.innerHTML = "";
    let letra = e.target.value;
    parrafo.textContent += letra;
});
