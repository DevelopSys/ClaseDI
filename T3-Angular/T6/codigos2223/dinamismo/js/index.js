// trabajar con etiquetas
// trabajar con class
// trabajar con id

/* // elemento que tenga el id --> unico
let elementoPorID = document.getElementById("lista");
console.log(elementoPorID);
// elemento que tenga el etiqueta --> lista (HTML ELEMENT lista)
let elementoPorTag = document.getElementsByTagName("li");
console.log(elementoPorTag);
// elemento que tenga el class --> lista (HTML ELEMENT lista)
let elementoPorClass = document.getElementsByClassName("m-4");
console.log(elementoPorClass); */

// #id .class tag
// --> elemento único --> primer elemento --> Node
//let elementQuery = document.querySelector("#lista");

// --> elemento multiple --> todos los elementos --> NodeList
//document.querySelectorAll();
//let elementosQuery = document.querySelectorAll("#lista1 li");
//let elementosQuery = document.querySelectorAll("ul.clase1");
/* let elementosQuery = document.querySelectorAll("ul.clase2 li");
elementosQuery.forEach((element) => {
  console.log(element.classList.contains("elemento1"));
}); */

// agregar
/* let elementoLista = document.querySelector("ul.clase2");
// 1 - crear un li
let nodoLI = document.createElement("li");
// 2 - personalizar li (agregar las clases y poner el contenido - tipo texto)
// nodoLI.className = "list-group-item";
//nodoLI.className = "elemento1";
nodoLI.classList.add("list-group-item");
nodoLI.classList.add("elemento1");
nodoLI.innerText = "Elemento 66";
// 3 - agregar el li al ul (encontrado!)
elementoLista.append(nodoLI); */

/* let elementoLista = document.querySelector("ul.clase2");
let listaHTML =
  elementoLista.innerHTML +
  `<li class="list-group-item elemento1">Elemento 66</li>`;

elementoLista.innerHTML = listaHTML; */

// borrar
/* let elementoLista = document.querySelector("ul.clase2");
let nodoLIBuscado = document.querySelector(".elemento3");
elementoLista.removeChild(nodoLIBuscado); */

let seleccion = document.querySelector("select");

let elementoLista = document.querySelector("ul.clase2");

document.querySelector("#boton_add").addEventListener("click", () => {
  console.log(seleccion.value);

  // if

  let listaHTML =
    elementoLista.innerHTML +
    `<li class="list-group-item elemento1">Elemento Nuevo</li>`;

  elementoLista.innerHTML = listaHTML;
});
