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
    if (titulo.length > 0 && descripcion.length > 0 && prioridad != "0") {
        agregarCarta(titulo, descripcion, prioridad, seleccionTipo.value);
    }
    else {
        Swal.fire({
            title: "Error?",
            text: "Faltan datos por rellenar",
            icon: "warning",
        });
    }
});
selectPrioridad === null || selectPrioridad === void 0 ? void 0 : selectPrioridad.addEventListener("change", (e) => {
    // console.log(e);
});
inputDescripcion === null || inputDescripcion === void 0 ? void 0 : inputDescripcion.addEventListener("keyup", (e) => {
    /* parrafo!!.innerHTML = "";
    let letra = e.target!!.value;
    parrafo!!.textContent += letra; */
});
function agregarCarta(...param) {
    console.log("Agregar carta");
    //  --> alta
    //
    //
    /* divCartas!!.innerHTML +=
    `<div class="col animate__animated animate__fadeInDown">
                <div class="card">
                  <img src="..." class="card-img-top" alt="..." />
                  <div class="card-body">
                    <h5 class="card-title">${titulo}</h5>
                    <p class="card-text">
                      ${descripcion}
                    </p>
                  </div>
                </div>
              </div>`; */
    let columna = document.createElement("div");
    columna.className = "col animate__animated animate__fadeInDown";
    // columna.classList.add()
    let carta = document.createElement("div");
    carta.className = "card";
    let imagen = document.createElement("img");
    imagen.className = "card-img-top";
    let urlImagen = "";
    switch (param[2]) {
        case "1":
            urlImagen =
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0T57gqsXzwNExoDv5_HFtU4usNFg06SbGGw&s";
            break;
        case "2":
            urlImagen =
                "https://thumbs.dreamstime.com/z/ilustraci%C3%B3n-de-prioridad-media-una-por-computadora-la-fondo-blanco-aislado-258590158.jpg";
            break;
        case "3":
            urlImagen =
                "https://st.depositphotos.com/4285885/54474/i/450/depositphotos_544749102-stock-photo-high-priority-words-written-red.jpg";
            break;
    }
    imagen.src = urlImagen;
    let cuerpo = document.createElement("div");
    cuerpo.className = "card-body";
    let tituloCard = document.createElement("h5");
    tituloCard.className = "card-title";
    tituloCard.innerText = param[0];
    let cuerpoCard = document.createElement("p");
    cuerpoCard.className = "card-text";
    cuerpoCard.innerText = param[1];
    cuerpo.append(tituloCard);
    cuerpo.append(cuerpoCard);
    carta.append(imagen);
    carta.append(cuerpo);
    columna.append(carta);
    divCartas === null || divCartas === void 0 ? void 0 : divCartas.append(columna);
    limpiarFormulario();
}
function limpiarFormulario() {
    inputDescripcion.value = "";
    inputTitulo.value = "";
    selectPrioridad.value = "0";
}
let tareas = []; // Lista
tareas.length; // longitud
tareas.push("asd", "asd"); // agrega elementos al final
tareas.unshift("asd", "asd"); // agrega elementos al principio
tareas.pop(); // elliminar el ultimo elemento
tareas.shift(); // elliminar el primer elemento
tareas[4] = "2"; // modifica la posicion 4, pero si no existe, la agrega
// recorrido
/* tareas.forEach((item) => {
  
}); */
// filtrado
tareas.filter((item) => {
    return true;
});
// busqueda
tareas.find((item) => {
    return true;
});
