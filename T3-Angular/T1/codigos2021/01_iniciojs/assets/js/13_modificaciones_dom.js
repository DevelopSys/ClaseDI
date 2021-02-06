console.log(document);
//console.log(window.history);
//console.log(window.history);
//window.open("https://www.marca.com");
// querySelectorAll --> NodeList
let divs = document.querySelectorAll("div");
let container = document.querySelectorAll(".container");
let emailInput = document.querySelectorAll("#exampleInputEmail1");
let busquedaAnidada = document.querySelectorAll("div.mb-3.form-check");
//let inputEmail = document.querySelectorAll("input#exampleInputEmail1");
let inputEmail = document.querySelectorAll("input[type='password']");
let inputs = document.querySelectorAll("input");

//console.log(inputs);
inputs.forEach((element) => {
  //console.log(element.value);
});

let inputUno = document.querySelector("input");
//console.log(inputUno);

let boton = document.querySelector("button");
//console.log(boton);

boton.addEventListener("click", () => {
  //console.log("El elemento ha sido pulsado");
  let email = document.querySelector("#inputEmail").value;
  let nombre = document.querySelector("#inputNombre").value;
  let pass = document.querySelector("#inputPass").value;
  let experiencia = document.querySelector("#inputCheck").checked;

  //console.log(`${nombre} ${email} ${pass} ${experiencia} `);
  //nodo.classList.add("list-group-item");
  //nodo.innerHTML = `<p> ${nombre} ${email} ${pass}</p>`;
  //document.querySelector("#lista_usuarios").classList.add("list-group");)

  if (experiencia) {
    let nodo = document.createElement("li");
    document.querySelector("#lista_usuarios").append(nodo);
    nodo.innerHTML = `<p>${nombre} ${email} ${pass}</p>`;

    nodo.classList.remove("list-group-item");
    //nodo.innerHTML = `<p> ${nombre} ${email} ${pass}</p>`;
    document.querySelector("#lista_usuarios").append(nodo);
    vaciarDatos();
    //document.querySelector("#lista_usuarios").classList.add("list-group");
  } else {
    alert("no puedo añadir porque no hay experiencia");
  }
});

const vaciarDatos = () => {
  let inputText = document.querySelectorAll("input.form-control");
  inputText.forEach((element) => {
    element.value = "";
  });

  //document.querySelector("#inputEmail").value = "";
  //document.querySelector("#inputNombre").value = "";
  //document.querySelector("#inputPass").value = "";
  //document.querySelector("#inputCheck").checked = false;
};

let botonChiste = document.querySelector("#boton_chiste");
botonChiste.addEventListener("click", () => {
  console.log("pulsado");
  fetch("https://api.chucknorris.io/jokes/random")
    .then((data) => data.json())
    .then((data) => {
      document.querySelector(
        "#chiste_div"
      ).innerHTML = `<div class="card" style="width: 18rem;">
      <img src="${data.icon_url}" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">${data.id}</h5>
        <p class="card-text">${data.value}</p>
        <a href="${data.url}" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>`;
    });
});

document.querySelector("#boton_usuarios").addEventListener("click", () => {
  // al pulsar el boton se pinten tantas cartas com
  // usuarios tenga el JSON
  fetch("https://randomuser.me/api/?results=50")
    .then((data) => data.json())
    .then((data) => {
      //console.log(data.results);
      data.results.forEach((contacto) => {
        let nodo = document.createElement("div");
        nodo.className = "col";
        nodo.innerHTML = `<div class="card" style="width: 18rem">
        <img src="${contacto.picture.large}" class="card-img-top" alt="..." />
        <div class="card-body">
          <h5 class="card-title">${contacto.name.first} ${contacto.name.last}</h5>
          <p class="card-text">
            ${contacto.email}
          </p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
      </div>`;

        document.querySelector("#contenedor_usuarios").append(nodo);
      });

      {
        /* <div class="card" style="width: 18rem">
            <img src="..." class="card-img-top" alt="..." />
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
              </p>
              <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
          </div> */
      }
    });
});

// https://randomuser.me/api/?results=50
