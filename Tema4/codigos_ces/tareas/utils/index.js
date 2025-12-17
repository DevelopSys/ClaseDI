let botonAgregar = document.querySelector("#btnAgregar");
let botonBuscar = document.querySelector("#btnBuscar");
let inputNombre = document.querySelector("#inputNombre");
let inputFecha = document.querySelector("#inputFecha");
let selectPrioridad = document.querySelector("#selectPrioridad");
let selectPrioridadBuscar = document.querySelector("#selectBuscar");
let lista = document.querySelector("#listaTareas");
let fila = document.querySelector("#filaCartas");

let tareas = [];

botonAgregar.addEventListener("click", () => {
  let nombre = inputNombre.value;
  let fecha = inputFecha.value;
  let prioridad = selectPrioridad.value;

  if (nombre.length == 0 || fecha.length == 0 || prioridad == 0) {
    // saltar un cuadro
    alert("No hay datos");
  } else {
    let tarea1 = new tarea(
      inputNombre.value,
      new Date(inputFecha.value),
      selectPrioridad.value
    );

    tareas.push(tarea1);

    lista.innerHTML = `<li class='form-control'>${
      tareas[tareas.length - 1].nombre
    }</li>`;
    inputNombre.value = "";
    inputFecha.value = "";
    selectPrioridad.value = "0";
  }
});

botonBuscar.addEventListener("click", () => {
  let seleccion = selectPrioridadBuscar.value;
  let listaFiltrada = tareas.filter((item) => {
    return item.prioridad == seleccion;
  });

  let imagen;
  switch (seleccion) {
    case "1":
      imagen = "";
      break;
    case "2":
      imagen = "";
      break;
    case "3":
      imagen = "";
      break;
  }
  Swal.fire({
    position: "center",
    icon: "success",
    title: `El numero de resultados es ${listaFiltrada.length}`,
    showConfirmButton: false,
    timer: 3000,
  });

  listaFiltrada.forEach((item) => {
    fila.innerHTML += `<div class="col">
    <div class="card">
      <img src="${imagen}" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">${item.nombre}</h5>
      </div>
    </div>
  </div>`;
  });
});
