let boton = document.querySelector("#boton_pulsar");
let inputNombre = document.querySelector("#input_nombre");
let inputTelefono = document.querySelector("#input_telefono");
let selectTipo = document.querySelector("#select_tipo");
let lis = document.querySelector("#lista_buscada li");
let lista = document.querySelector("ul");
let h1 = document.querySelectorAll("h1");
console.log(h1);

/* liBuscado.classList.add('elemento_profesor');
liBuscado.classList.remove('list-group-item') */

h1.forEach((element, index) => {
  if (index % 2 == 0) {
    element.innerText += " Nodo Par";
  } else {
    element.innerText += " Nodo Impar";
  }
});

boton.addEventListener("click", (element) => {
  if (inputNombre.value.length != 0 && inputTelefono.value.length == 9) {
    //console.log(selectTipo.value);
    lista.innerHTML += `<li class='list-group-item'>${inputNombre.value} - ${inputTelefono.value}</li>`;
    lis = document.querySelectorAll("#lista_buscada li");
    lis.forEach((element,index) => {
      // lo que le pasa a cada elemento (li);
      element.addEventListener("click", (e) => {console.log(e);});
    });
  } else {
    alert("No has introducido datos");
  }
});

/* for (let index = 0; index < h1.length; index++) {
    h1[index].innerText = "Modificación de todos";
} */

//h1[4].innerText = "Modificación del DOM del H1"
