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
  // añadir a la lista -> <li>asdasd</li>

  if (
    inputNombre.value.length > 0 &&
    Number(inputPrecio.value) > 0 &&
    inputDescripcion.value.length > 0
  ) {
    insertarProducto(inputNombre.value, inputPrecio.value);
  } else {
    Swal.fire({
      title: "Error",
      text: "Falta algun dato por rellenar",
      icon: "error",
      timer: 1500,
    });
  }
  // mediante swAlerts avisar de que el producto con nombre XX añadido correctamente
  // desaparece a las 2seg
  // todos los campos se limpian
  // no
  // lanza un dialogo de error con swAlerts
});
function limpiarCampos() {
  for (let index = 0; index < arguments.length; index++) {
    arguments[index].value = "";
  }
}

function insertarProducto(nombre, precio) {
  // listaProductos.innerHTML += `<li class='list-group-item animate__animated animate__fadeInRight'>${nombre} - ${precio} <button class='btn btn-danger'>Eliminar</button></li>`;
  let nodoLI = document.createElement("li");
  nodoLI.textContent = `${nombre} - ${precio}`;
  nodoLI.className = "list-group-item animate__animated animate__fadeInRight";
  nodoLI.classList.add(
    "list-group-item",
    "animate__animated",
    "animate__fadeInRight",
  );
  listaProductos.appendChild(nodoLI);
  Swal.fire({
    title: "Existo",
    text: "Producto agregado correctamente",
    icon: "success",
    timer: 1500,
  });
  limpiarCampos(inputNombre, inputPrecio, inputDescripcion);
}
