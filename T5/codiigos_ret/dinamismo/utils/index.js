// nada -> tag
// .clase -> clase
// #id -> id
// .clase#id
// .clase #id
// input[type=radio]
// unicas -> querySelect -> un elemento -> HtmlNode
// unicas -> querySelectAll -> varios elementos -> NodeList
let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let boton = document.querySelector("#botonAnadir");
let parrafo = document.querySelector("p");
boton.addEventListener("click", (e) => {
  console.log(e);

  parrafo.innerText = `Mi nombre es ${inputNombre.value} y mi apellido es ${inputApellido.value}`;
  /* console.log(`El dato del nombre es: ${inputNombre.value}`);
  console.log(`El dato del apellido es: ${inputApellido.value}`); */
});

console.log(inputsData);
