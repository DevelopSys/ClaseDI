// id class tag --> getElementByXXXX
// selectores

// document.querySelector --> HTMLELEMENT -> button --> primera ocurrencia
// document.querySelectorAll --> NodeList -> List<Button> --> lista completa de elementos

//let boton = document.querySelector("button");
//let boton = document.querySelector("#boton_borrar");
//let boton = document.querySelector(".btn");
//console.log(boton);
//let lista = document.querySelector("ul.elemento");
//let lista = document.querySelector("div.container ul.elemento");
//let elementosLi = document.querySelector("ul").querySelectorAll("li");

let botonAgregar = document.querySelector("#boton_agregar");
let botonBorrar = document.querySelector("#boton_borrar");
let listaUno = document.querySelector("#lista_uno");
let listaDos = document.querySelector("#lista_dos");
let select = document.querySelector("#select_lista");
let elementosLi = document.querySelectorAll("ul.elemento li");
let inputAgregar = document.querySelector("#input_agregar");
let filaProfesores = document.querySelector(".row");
let listaSeleccionada = -1;
let profesores = [
  {
    nombre: "Ejemplo",
    apellido: "Ejemplo",
    edad: 18,
    correo: "ejemplo@gmail.om",
    asignaturas: [
      {
        nombre: "Desarrollo de interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Programacion multimedia",
        horas: 6,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    edad: 18,
    correo: "bmartinh@gmail.om",
    asignaturas: [
      {
        nombre: "Desarrollo de interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Programacion multimedia",
        horas: 6,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Alberto",
    apellido: "Fernandez",
    edad: 18,
    correo: "alberto.fernandez@gmail.om",
    asignaturas: [
      {
        nombre: "Acceso a datos",
        horas: 5,
        siglas: "AD",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Ferando",
    apellido: "Sanchez",
    edad: 24,
    correo: "fernando@gmail.om",
    asignaturas: [
      {
        nombre: "Programacion",
        horas: 8,
        siglas: "PRO",
        ciclo: "DAM",
        curso: 1,
      },
      {
        nombre: "Base datos",
        horas: 6,
        siglas: "BD",
        ciclo: "DAM",
        curso: 1,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Carlos",
    apellido: "Sanchez",
    edad: 28,
    correo: "carlos@gmail.om",
    asignaturas: [
      {
        nombre: "Entornos de Desarrollo",
        horas: 3,
        siglas: "ED",
        ciclo: "DAM",
        curso: 1,
      },
      {
        nombre: "Sistemas de Gestión empresarial",
        horas: 3,
        siglas: "SGE",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
  {
    nombre: "Manuel",
    apellido: "PErez",
    edad: 28,
    correo: "manuel@gmail.om",
    asignaturas: [
      {
        nombre: "Empresa e iniciativa emprendedora",
        horas: 3,
        siglas: "EIE",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.edad);
    },
  },
];

profesores.forEach((item) => {
  /*   item.apellido
  item.nombre
  item.correo */
  // crear una carta y colocalar en el row filaProfesores
  filaProfesores.innerHTML += `<div class="col">
            <div class="card" style="width: 18rem">
              <div class="card-body">
                <h5 class="card-title">${item.nombre}</h5>
                <h6 class="card-subtitle">${item.apellido}</h6>
                <p class="card-text">
                  ${item.correo}
                </p>
              </div>
            </div>
          </div>`;

  let nodoLista = document.createElement("ul");
  nodoLista.innerHTML; // agregar li
  // nodolista agrego a la carta
  // foreach de las asignaturas item.asignaturas --> agregarlas en la ul
});

select.addEventListener("change", (e) => {
  //console.log(select.value);
  console.log(e.target.value);
  //listaSeleccionada = select.value;
});

function agregarDato(dato, lista) {
  let nodoLI = document.createElement("li");
  nodoLI.className = "list-group-item";
  nodoLI.textContent = dato;
  lista.append(nodoLI);
  //lista.innerHTML += `<li class="list-group-item">${dato}</li>`;
}

botonAgregar.addEventListener("click", (event) => {
  if (inputAgregar.value) {
    select.value == 1
      ? agregarDato(inputAgregar.value, listaUno)
      : agregarDato(inputAgregar.value, listaDos);
  } else {
    alert("No se han introducido datos");
  }
  //console.log("boton puslado");
  //<li>Elemento nuevo</li>
  //listaUno.innerHTML += `<li class="list-group-item">Elemento prueba</li>`;
  /* let nodoLI = document.createElement("li");
  nodoLI.textContent = "Elemento prueba";
  //nodoLI.className = "list-group-item";
  nodoLI.classList.add("list-group-item");
  nodoLI.addEventListener("click", (event) => {
    console.log("Ejemplo de cosa");
  });
  listaUno.append(nodoLI);
});
botonBorrar.addEventListener("click", (event) => {
  console.log("boton puslado"); */
});

/* elementosLi.forEach((element) => {
  //console.log(element.textContent);
  console.log(element.innerHTML);
}); */
