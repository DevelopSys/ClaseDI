let rowCard = document.querySelector("#row-card");
let boton = document.querySelector("button");
let lista = document.querySelector("#lista-tareas");
let inputTitulo = document.querySelector("#input-titulo");
let inputDescripcion = document.querySelector("#input-detalle");
let inputFecha = document.querySelector("#input-fecha");
let checkPriotaria = document.querySelector("#check_priotaria");
let selectPrioridad = document.querySelector("#select-prioridad");
let selectFiltro = document.querySelector("#select-filtro");
let listaTareas = [];
let contador = 1;

boton.addEventListener("click", (ev) => {
  /* let inputs = document.querySelectorAll("#select-prioridad");
  console.log(inputs); */
  // se añada un elemento a la lista que esta en la derecha
  // lista.innerHTML += "<li class='list-group-item'>Elemento</li>";
  listaTareas.push(
    new Tarea(
      contador,
      inputTitulo.value,
      inputDescripcion.value,
      selectPrioridad.value,
      checkPriotaria.checked,
      inputFecha.value
    )
  );
  contador++;
  console.log(listaTareas);
  lista.appendChild(crearNodo(listaTareas[listaTareas.length - 1]));
  crearCarta(listaTareas[listaTareas.length - 1]);
});

function crearNodo(tarea) {
  let nodoLI = document.createElement("li");
  //nodoLI.className = "list-group-item";
  nodoLI.classList.add("list-group-item");

  //nodoLI.classList.add("active");
  nodoLI.id = "tarea-" + tarea.id;
  nodoLI.textContent = tarea.titulo;
  nodoLI.addEventListener("click", (e) => {
    lista.childNodes.forEach((element) => {
      element.classList.remove("active");
    });
    // se ponga la clase active
    e.target.classList.add("active");
  });
  return nodoLI;
}

function crearCarta(tarea) {
  let image;
  switch (Number(tarea.prioridad)) {
    case 0:
      image =
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4tANuBJoViapolNoVPmOHlaaFityDbdvSyyhUVpIL_MvB2K3IS6DNmUXkAtzhOPbbHRc&usqp=CAU";
      break;
    case 1:
      image =
        "https://static-00.iconduck.com/assets.00/medium-priority-icon-512x512-kpm2vacr.png";
      break;
    case 2:
      image =
        "https://static-00.iconduck.com/assets.00/high-priority-icon-1024x1024-ryazhwgn.png";
      break;

    default:
      break;
  }

  rowCard.innerHTML += `<div class="col" id='tarea-${tarea.id}'}>
  <div class="card" style="width: 18rem;">
    <img src='${image}' class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">${tarea.titulo}</h5>
      <p class="card-text">${tarea.descripcion}</p>
      <button onClick=(completarTarea(${tarea.id})) id=${tarea.id} class='btn btn-primary'>Completar</button>
    </div>
  </div>
</div>`;
}

function completarTarea(id) {
  let elemento = document.querySelector(`#lista-tareas li#tarea-${id}`);
  lista.removeChild(elemento);
  //console.log(elemento);
}

selectFiltro.addEventListener("change", (e) => {
  lista.innerHTML = "";
  let priodidadSeleccionada = e.target.value;
  listaTareas.forEach((item) => {
    if (priodidadSeleccionada == -1) {
      lista.appendChild(crearNodo(item));
    } else if (item.prioridad == priodidadSeleccionada) {
      lista.appendChild(crearNodo(item));
    }
  });
});
