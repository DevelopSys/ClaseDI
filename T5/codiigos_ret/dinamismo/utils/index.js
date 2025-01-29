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
let listaFiltrada = document.querySelector("#listaFiltrada");
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
  /* lista.innerHTML = "";
  usuarios = []; */
  lista.childNodes[0].classList.remove("animate__fadeInUp");
  lista.childNodes[0].classList.add("animate__rubberBand");
  setTimeout(() => {
    lista.childNodes[0].classList.remove("animate__rubberBand");
    lista.childNodes[0].classList.add("animate__fadeOutRight");
    setTimeout(() => {
      lista.removeChild(lista.childNodes[0]);
      lista.childNodes.forEach((item) => {
        setTimeout(() => {
          item.classList.remove("animate__fadeInUp");
          item.classList.add("animate__fadeInDownBig");
        }, 200);
      });
    }, 600);
  }, 600);
});

botonFiltrar.addEventListener("click", (e) => {
  listaFiltrada.innerHTML = "";
  let seleccionBusqueda = selectFiltro.value;

  console.log(seleccionBusqueda);

  // todos aquellos que cumplen con la formacion
  let listaFiltro = usuarios.filter((element) => {
    return element.formacion == seleccionBusqueda;
  });
  console.log(listaFiltro);

  listaFiltro.forEach((item) => {
    agregarNodoLIFiltro(item.nombre, item.apellido, item.edad, item.estudios);
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
    usuarios.push(new Usuario(nombre, apellido, edad, estudios));
  } else {
    Swal.fire({
      title: "Error",
      text: "Por favor comprueba todos los datos",
      icon: "error",
    });
  }
}

function agregarNodoLIFiltro(nombre, apellido, edad, estudios) {
  let nodoLI = document.createElement("li");
  // nodoLI.className = "list-group-item animate__animated animate__fadeInUp"
  nodoLI.textContent = `${nombre} ${apellido}`;
  nodoLI.classList.add(
    "list-group-item",
    "animate__animated",
    "animate__fadeInUp"
  );
  listaFiltrada.append(nodoLI);
}

function limpiarElementos() {
  inputNombre.value = "";
  inputEdad.value = "";
  inputApellido.value = "";
  selectFormacion.value = "Formacion basica";
}

console.log(inputsData);
