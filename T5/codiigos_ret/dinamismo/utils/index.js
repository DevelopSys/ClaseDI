// nada -> tag
// .clase -> clase
// #id -> id
// .clase#id
// .clase #id
// input[type=radio]
// unicas -> querySelect -> un elemento -> HtmlNode
// unicas -> querySelectAll -> varios elementos -> NodeList
let usuarios = [];
let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let inputEdad = document.querySelector("#inputEdad");
let selectFormacion = document.querySelector("#selectFormacion");
let selectFiltro = document.querySelector("#selectFiltro");
let boton = document.querySelector("#botonAnadir");
let botonBorrar = document.querySelector("#botonBorrar");
let botonFiltrar = document.querySelector("#botonFiltrar");
let lista = document.querySelector("div#resultados ul");
// let parrafo = document.querySelector("p");
boton.addEventListener("click", (e) => {
  // parrafo.innerText = `Mi nombre es ${inputNombre.value} y mi apellido es ${inputApellido.value}`;
  /* console.log(`El dato del nombre es: ${inputNombre.value}`);
  console.log(`El dato del apellido es: ${inputApellido.value}`); */
  agregarNodoLI(
    inputNombre.value,
    inputApellido.value,
    parseInt(inputEdad.value),
    selectFormacion.value
  );
  usuarios.push(
    new Usuario(
      inputNombre.value,
      inputApellido.value,
      inputEdad.value,
      selectFormacion.value
    )
  );
});

botonBorrar.addEventListener("click", (e) => {
  lista.innerHTML = "";
  usuarios = [];
});

botonFiltrar.addEventListener("click", (e) => {
  listaFiltrada.innerHTML = "";
  let seleccionBusqueda = selectFormacion.value;
  // todos aquellos que cumplen con la formacion
  usuarios
    .filter((element) => {
      return (element.formacion = seleccionBusqueda);
    })
    .forEach((item) => {
      agregarNodoLI(item.nombre, item.apellido);
    });
});

function agregarNodoLI(nombre, apellido, edad, estudios) {
  if (nombre.length > 0 && apellido.length > 0) {
    // 1. de forma directa
    // lista.innerHTML += `<li class="list-group-item animate__animated animate__fadeInUp">${nombre} - ${apellido}</li>`;
    // limpiarElementos();
    // 2. completa
    let nodoLI = document.createElement("li");
    // nodoLI.className = "list-group-item animate__animated animate__fadeInUp"
    nodoLI.textContent = `${nombre} ${apellido}`;
    nodoLI.classList.add(
      "list-group-item",
      "animate__animated",
      "animate__fadeInUp"
    );
    lista.append(nodoLI);
  } else {
    Swal.fire({
      title: "Error",
      text: "Por favor comprueba todos los datos",
      icon: "error",
    });
  }
}

function limpiarElementos() {
  inputNombre.value = "";
  inputEdad.value = "";
  inputApellido.value = "";
  selectFormacion.value = "Formacion basica";
}

console.log(inputsData);
