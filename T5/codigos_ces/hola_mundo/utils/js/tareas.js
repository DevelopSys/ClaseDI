"use strict";
let boton = document.querySelector("#boton-agregar");
let inputTitulo = document.querySelector("#input-titulo");
let inputDescripcion = document.querySelector("#input-descripcion");
let selectPrioridad = document.querySelector("#select-prioridad");
let parrafo = document.querySelector("#parrafo-principal");
let divCartas = document.querySelector("#resultadoCartas");
// EVENTOS
boton === null || boton === void 0 ? void 0 : boton.addEventListener("click", (e) => {
    //console.log(e);
    let titulo = inputTitulo === null || inputTitulo === void 0 ? void 0 : inputTitulo.value;
    let descripcion = inputDescripcion === null || inputDescripcion === void 0 ? void 0 : inputDescripcion.value;
    let prioridad = selectPrioridad === null || selectPrioridad === void 0 ? void 0 : selectPrioridad.value;
    let seleccionTipo = document.querySelector("input[type='radio']:checked");
    console.log(seleccionTipo.value);
    divCartas.innerHTML += `<div class="col animate__animated animate__fadeInDown">
              <div class="card">
                <img src="..." class="card-img-top" alt="..." />
                <div class="card-body">
                  <h5 class="card-title">${titulo}</h5>
                  <p class="card-text">
                    ${descripcion}
                  </p>
                </div>
              </div>
            </div>`;
});
selectPrioridad === null || selectPrioridad === void 0 ? void 0 : selectPrioridad.addEventListener("change", (e) => {
    // console.log(e);
});
inputDescripcion === null || inputDescripcion === void 0 ? void 0 : inputDescripcion.addEventListener("keyup", (e) => {
    /* parrafo!!.innerHTML = "";
    let letra = e.target!!.value;
    parrafo!!.textContent += letra; */
});
/* <div class="col">
              <div class="card">
                <img src="..." class="card-img-top" alt="..." />
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">
                    This is a longer card with supporting text below as a
                    natural lead-in to additional content. This content is a
                    little bit longer.
                  </p>
                </div>
              </div>
            </div> */
