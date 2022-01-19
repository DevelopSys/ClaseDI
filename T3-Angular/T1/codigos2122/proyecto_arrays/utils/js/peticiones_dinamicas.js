let input = document.querySelector("#input-numero");
let select = document.querySelector("#select-genero");
let boton = document.querySelector("#boton-filtro");
let divCartas = document.querySelector("#contenedor-cartas");

boton.addEventListener("click", (e) => {
  let genero = select.value;
  let numero = input.value;
  let url = `https://randomuser.me/api/?results=${numero}&gender=${genero}`;
  fetch(url)
    .then((res) => {
      return res.json();
    })
    .then((res) => {
      res.results.forEach((element) => {
        let nodo = document.createElement("div");
        nodo.classList.add("col");
        nodo.innerHTML = `<div class="card" style="width: 18rem;">
        <img src="${element.picture.medium}" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">${element.name.first}</h5>
          <p class="card-text">${element.gender}</p>
        </div>
      </div>`;

        divCartas.append(nodo);
      });
    });
});
