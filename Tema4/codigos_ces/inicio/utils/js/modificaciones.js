let botonAgregar = document.querySelector("#btnAgregar");
let botonLimpiar = document.querySelector("#btnLimpiar");
let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let inputFecha = document.querySelector("#inputFecha");
let listaAgregados = document.querySelector("#divAgregados ul");

botonAgregar.addEventListener("click", (ev) => {
  let nombre = inputNombre.value;
  let apellido = inputApellido.value;
  let fecha = inputFecha.value;

  let cosa = "";
  if (nombre.length == 0 || apellido.length == 0 || fecha.length == 0) {
    lanzarDialogo("Error", "Faltan datos", "warning");
  } else {
    agregarLi(nombre, apellido, fecha);
  }
});

botonLimpiar.addEventListener("click", (ev) => {
  limpiarCampos(inputNombre, inputApellido, inputFecha);
});

function limpiarCampos() {
  for (let index = 0; index < arguments.length; index++) {
    arguments[index].value = "";
  }
}

function lanzarDialogo(title, text, icon) {
  Swal.fire({
    title: title,
    text: text,
    icon: icon,
  });
}

function agregarLi(nombre, apellido, fecha) {
  /* listaAgregados.innerHTML += `<li
            class="animate__animated animate__fadeInRight list-group-item d-flex justify-content-between align-items-start"
          >
            ${nombre} ${apellido} ${fecha}
          </li>`; */

  let nodoLI = document.createElement("li");
  nodoLI.innerText = `${nombre} ${apellido} ${fecha}`;
  /* nodoLI.className =
    "animate__animated animate__fadeInRight list-group-item d-flex justify-content-between align-items-start"; */
  nodoLI.classList.add(
    "animate__animated",
    "animate__fadeInRight",
    "list-group-item",
    "d-flex",
    "justify-content-between",
    "align-items-start"
  );
  listaAgregados.appendChild(nodoLI);
  limpiarCampos(inputNombre, inputApellido, inputFecha);

  /* lanzarDialogo(
    "Agregado correctamente",
    `Usuario con nombre ${nombre} agregado correctamente`,
    "success"
  ); */
}
