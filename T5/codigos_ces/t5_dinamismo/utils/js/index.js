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
      inputTitulo.value,
      inputDescripcion.value,
      selectPrioridad.value,
      checkPriotaria.checked,
      inputFecha.value
    )
  );
  contador++;
  console.log(listaTareas);
  let nodoLI = document.createElement("li");
  //nodoLI.className = "list-group-item";
  nodoLI.classList.add("list-group-item");
  nodoLI.textContent = listaTareas[listaTareas.length - 1].titulo;

  lista.appendChild(nodoLI);
});

selectFiltro.addEventListener("change", (e) => {
  lista.innerHTML = "";
  let priodidadSeleccionada = e.target.value;
  listaTareas.forEach((item) => {
    if (priodidadSeleccionada == -1) {
      lista.innerHTML += `<li class="list-group-item">${item.titulo}</li> `;
    } else if (item.prioridad == priodidadSeleccionada) {
      lista.innerHTML += `<li class="list-group-item">${item.titulo}</li> `;
    }
  });
});
