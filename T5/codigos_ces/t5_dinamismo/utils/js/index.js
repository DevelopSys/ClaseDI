let boton = document.querySelector("button");
let lista = document.querySelector("#lista-tareas");
let listaTareas = [];
let contador = 1;
boton.addEventListener("click", (ev) => {
  /* let inputs = document.querySelectorAll("#select-prioridad");
  console.log(inputs); */
  // se añada un elemento a la lista que esta en la derecha
  // lista.innerHTML += "<li class='list-group-item'>Elemento</li>";
  listaTareas.push(
    new Tarea(`Titulo${contador}`, "Descripcion", "Alta", false, "12/12/2024")
  );
  contador++;
  console.log(listaTareas);
  let nodoLI = document.createElement("li");
  //nodoLI.className = "list-group-item";
  nodoLI.classList.add("list-group-item");
  nodoLI.textContent = listaTareas[listaTareas.length - 1].titulo;
  lista.appendChild(nodoLI);
});
