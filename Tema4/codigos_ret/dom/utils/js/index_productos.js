// document.getElementById("id") -> HTML
// document.getElementByClass("btn") -> HTML
// document.getElementByTag("button") -> HTML
//let botones =  document.getElementsByClassName("btn") -> HTML ELEMENT -> LIST
// document.querySelector(".clase") -> HTML
// document.querySelector("#id") -> HTML
// document.querySelector("tag") -> HTML
// document.querySelector("div.contenido ul.lista-principal input[type=text]")
const botonRegistrar = document.querySelector("#boton-registrar");
const inputNombre = document.querySelector("#input-nombre");
const inputPrecio = document.querySelector("#input-precio");
const inputDescripcion = document.querySelector("#input-descripcion");
const selectCategoria = document.querySelector("#select-categoria");
const spanCaracteres = document.querySelector("span");
const listaProductos = document.querySelector("ul");

// spanCaracteres.innerText = "Esto lo cambio";
botonRegistrar.addEventListener("click", (e) => {
  // ver si los campos esta completos
  // si
  console.log(inputNombre.value);
  console.log(inputPrecio.value);
  console.log(inputDescripcion.value);
  console.log(selectCategoria.value);
  // añadir a la lista -> <li>asdasd</li>
  listaProductos.innerHTML += `<li class='list-group-item'>${inputNombre.value} - ${inputPrecio.value}</li>`;
  // mediante swAlerts avisar de que el producto con nombre XX añadido correctamente
  // desaparece a las 2seg
  // todos los campos se limpian
  // no
  // lanza un dialogo de error con swAlerts
});
