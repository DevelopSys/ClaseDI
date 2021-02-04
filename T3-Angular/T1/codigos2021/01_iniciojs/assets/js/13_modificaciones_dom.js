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
