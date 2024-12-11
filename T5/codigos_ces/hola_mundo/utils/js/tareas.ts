let boton = document.querySelector("#boton-agregar");
let inputTitulo = document.querySelector("#input-titulo");
let inputDescripcion = document.querySelector("#input-descripcion");
let selectPrioridad = document.querySelector("#select-prioridad");
let parrafo = document.querySelector("#parrafo-principal");

// EVENTOS
boton?.addEventListener("click", (e) => {
  console.log(e);
});

selectPrioridad?.addEventListener("change", (e) => {
  console.log(e);
});

inputDescripcion?.addEventListener("keyup", (e) => {
  parrafo!!.innerHTML = "";
  let letra = e.target!!.value;
  parrafo!!.textContent += letra;
});
